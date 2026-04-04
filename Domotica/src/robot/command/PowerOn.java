
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.PowerDecorator;

public class PowerOn extends AbsCommandImpl <PowerDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        PowerDecorator module = target.getModule(PowerDecorator.class);
        
        if (canExecute(module)) {
            module.turnOn();
            
        } else {
            System.out.println("!! Comando " + getActionDescription() + 
                    " No pudo realizarse en: " + target.toString() + " --> Ya Encendido.");
        }
    }

    @Override
    public boolean canExecute(PowerDecorator module) {
        return !module.isPowered();
    }

    @Override
    public String getActionDescription() {
        return "[on] Encender.";
    }
    
}
