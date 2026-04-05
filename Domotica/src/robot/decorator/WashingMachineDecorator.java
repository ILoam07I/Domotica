
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
        System.out.print("\t--> Empezando lavado " + this.getRobotState().getLaundryParam() + this.getRobotState().getNoiseParam());
        pauseWithDots();
        
        wmlocked = true;
        System.out.println("\t\tBloqueando lavadora.");
    }
    
    public void stopLaundry() {
        System.out.print("\t--> Parando lavado.");
        pauseWithDots();
        
        wmlocked = false;
        System.out.println("\t\tDesbloqueando lavadora.");
    }

    @Override
    public void forceShutOff() {
        if (wmlocked) {
            stopLaundry();
        }
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Washing M\t[ " + (wmlocked ? "DOING LAUNDRY" : "RESTING") + " ]";
    }   
      
}
