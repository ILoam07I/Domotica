package robot;

import java.util.List;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.module.RobotModule; // Importamos la nueva interfaz
import robot.state.State;

public interface Robot extends Comparable<Robot> {
    
    public String getModelName();
    public void setModelName(String model);
    
    public String getId();
    public void setId(String id);
    
    public List<? extends Event> getEvents();
    public void setEvents(List<? extends Event> getEvents);
    
    public State getRobotState();    
    public void changeToEcoMode();
    public void changeToNightMode();
    public void changeToNormalMode();
    
    // --- NUEVOS MÉTODOS DE LA MOCHILA ---
    public void addModule(Class<? extends RobotModule> type, RobotModule module);
    public <T extends RobotModule> T getModule(Class<T> type);
    
    public void performAction(Command command);
    public void forceShutOff();
    public String describe();
    
    @Override
    public int compareTo(Robot o);
    @Override
    public boolean equals(Object obj);
    @Override
    public String toString();
}
