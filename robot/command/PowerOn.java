package robot.command;

import robot.AbsRobotImpl;
import robot.module.PowerModule;

public class PowerOn extends Command<AbsRobotImpl> {

    @Override
    public void execute(AbsRobotImpl target) {
        // El comando mete la mano en la mochila y saca el módulo de energía
        PowerModule power = target.getModule(PowerModule.class);
        
        if (power != null) {
            power.turnOn();
        }
    }

    @Override
    public boolean canExecute(AbsRobotImpl target) {
        return !target.isPowered();
    }

    @Override
    public String getActionDescription() {
        return "[on] Encender.";
    }
    
}
