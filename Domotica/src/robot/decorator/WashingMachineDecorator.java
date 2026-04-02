
package robot.decorator;

import robot.Robot;
import robot.command.Command;

public class WashingMachineDecorator extends AbsRobotDecoratorImpl {
    
    private boolean wmlocked;

    public WashingMachineDecorator(Robot wrapee) {
        super(wrapee);
        wmlocked = false;
    }

    @Override
    public void performAction(Command command) {
        wrappee.performAction(command);
    }

    public boolean isWmlocked() {
        return wmlocked;
    }
    
    public void initLaundry() {
        wmlocked = true;
    }
    
    public void stopLaundry() {
        wmlocked = false;
    }

    @Override
    public void forceShutOff() {
        wmlocked = false;
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Wahsing Machine[ " + (wmlocked ? "DOING LAUNDRY" : "RESTING") + " ]";
    }   
      
}
