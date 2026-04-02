
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.command.PowerOff;
import robot.command.PowerOn;

public class PowerDecorator extends AbsRobotDecoratorImpl {
    
    private boolean powered;

    public PowerDecorator(Robot wrapee) {
        super(wrapee);
        this.powered = false;
    }

    public boolean isPowered() {
        return powered;
    }
    
    public void turnOn() {
        powered = true;
    }

    @Override
    public void performAction(Command command) {
        
        if (powered) {           
            if (command.getClass() == PowerOff.class) {
                command.execute(this);
            }
            wrappee.performAction(command);
            
        } else if (command.getClass() == PowerOn.class) {
            command.execute(this);
        }    
    }

    @Override
    public void forceShutOff() {
        powered = false;
        wrappee.forceShutOff();
    }
    
    @Override
    public String describe() {
        return wrappee.describe() + "\n\t Power[ " + (powered ? "ON" : "OFF") + " ]";
    }
    
}
