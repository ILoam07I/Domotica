
package robot.command;

import robot.decorator.AbsRobotDecoratorImpl;
import robot.decorator.PowerDecorator;

public class PowerOffCommand extends AbsCommandImpl <AbsRobotDecoratorImpl> {

    public PowerOffCommand(AbsRobotDecoratorImpl target) {
        super(target);
    }

    @Override
    public void execute() {
        PowerDecorator powerModule = target.getModule(PowerDecorator.class);
        
        if (powerModule != null) {
            powerModule.turnOff();
        }
    }
    
}
