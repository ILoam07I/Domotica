
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.command.InitLaundry;
import robot.command.StopLaundry;

public class WashingMachineDecorator extends AbsRobotDecoratorImpl {
    
    private boolean wmlocked;

    public WashingMachineDecorator(Robot wrapee) {
        super(wrapee);
        wmlocked = false;
    }

    @Override
    public void performAction(Command command) {
        if (command.getClass() == InitLaundry.class) {
            command.execute(this);
            
        } else if (command.getClass() == StopLaundry.class) {
            command.execute(this);
            
        } else {        
            wrappee.performAction(command);
        }
    }

    public boolean isWmlocked() {
        return wmlocked;
    }
    
    public void initLaundry() {
        System.out.println("\t--> Empezando lavado " + robotState.getLaundryParam() + robotState.getNoiseParam());
        
        wmlocked = true;
        System.out.println("\t\tBloqueando lavadora.");
    }
    
    public void stopLaundry() {
        System.out.println("\t--> Parando lavado.");
        
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
        return wrappee.describe() + "\n\t- Wahsing Machine[ " + (wmlocked ? "DOING LAUNDRY" : "RESTING") + " ]";
    }   
      
}
