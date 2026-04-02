
package robot.decorator;

import robot.Robot;
import robot.command.Command;

public class OvenDecorator extends AbsRobotDecoratorImpl {
    
    private boolean ovenLocked;

    public OvenDecorator(Robot wrappee) {
        super(wrappee);
        ovenLocked = false;
    }

    public boolean isOvenLocked() {
        return ovenLocked;
    }

    @Override
    public void performAction(Command command) {
        wrappee.performAction(command);
    }  
       
    public void initHeat() {
        ovenLocked = true;
    }
    
    public void stopHeat() {
        ovenLocked = false;
    }

    @Override
    public void forceShutOff() {
        ovenLocked = false;
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Oven[ " + (ovenLocked ? "HEATING" : "RESTING") + " ]";
    }
    
}
