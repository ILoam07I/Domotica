
package robot.command;

import robot.decorator.AbsRobotDecoratorImpl;
import robot.decorator.PowerDecorator;

public class PowerOnCommand extends AbsCommandImpl <AbsRobotDecoratorImpl> {

    public PowerOnCommand(AbsRobotDecoratorImpl target) {
        super(target);
    }

    @Override
    public boolean canExecute() {
        return !target.getModule(PowerDecorator.class).isPowered();
    }

    @Override
    public void execute() {        
        PowerDecorator powerModule = target.getModule(PowerDecorator.class);
        
        if (powerModule != null) {
            powerModule.turnOn();
        }
    }
    
}
