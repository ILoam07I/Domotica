package robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.module.PowerModule;
import robot.module.RobotModule;
import robot.state.NormalMode;
import robot.state.State;

public abstract class AbsRobotImpl implements Robot {
    
    protected String modelName;
    protected String id;
    protected State robotState;
    protected List<? extends Event> events;
    
    // LA MOCHILA
    protected Map<Class<? extends RobotModule>, RobotModule> modules;

    public AbsRobotImpl() {
        robotState = new NormalMode();
        events = new ArrayList<>();
        modules = new HashMap<>(); // Inicializamos la mochila
    }

    // --- GESTIÓN DE MÓDULOS ---
    @Override
    public void addModule(Class<? extends RobotModule> type, RobotModule module) {
        modules.put(type, module);
    }

    @Override
    public <T extends RobotModule> T getModule(Class<T> type) {
        return type.cast(modules.get(type));
    }

    // --- LA PUERTA DE ENTRADA (Control de Energía) ---
    @Override
    public void performAction(Command command) {
        PowerModule power = getModule(PowerModule.class);
        
        // INTERCEPCIÓN GLOBAL: Si tiene módulo de energía y está apagado...
        if (power != null && !power.isPowered()) {
            // ...solo permitimos ejecutar el comando PowerOn
            if (!command.getClass().getSimpleName().equals("PowerOn")) {
                // Bloqueado en la entrada, ni siquiera se ejecuta
                return;
            }
        }
        
        // Si hay energía (o es la orden de encender), el comando se ejecuta sobre la mochila
        command.execute(this);
    }

    @Override
    public void forceShutOff() {
        // Apagamos todos los módulos de golpe dinámicamente
        for (RobotModule module : modules.values()) {
            module.forceShutOff();
        }
    }
    
    @Override
    public String describe() {
        StringBuilder desc = new StringBuilder(toString());
        // Agregamos la descripción de todas las piezas que lleve encima
        for (RobotModule module : modules.values()) {
            desc.append(module.describe());
        }
        return desc.toString();
    }

    @Override
    public void changeToEcoMode() {
        robotState = robotState.changeToEcoMode();
    }

    @Override
    public void changeToNightMode() {
        robotState = robotState.changeToNightMode();
    }

    @Override
    public void changeToNormalMode() {
        robotState = robotState.changeToNormalMode();
    }

    @Override
    public int compareTo(Robot o) {
        return this.id.compareTo(o.getId());
    }
    
    @Override
    public boolean equals(Object obj) {
        Robot o = (Robot) obj;
        
        return id.equalsIgnoreCase(o.getId());
    }
    
    @Override
    public String toString() {
        return id + " " + modelName;
    }
}
