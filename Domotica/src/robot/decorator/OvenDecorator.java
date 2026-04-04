
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
        System.out.print("\t--> Empezando a calentar a " + this.getRobotState().getOvenTemperatureParam() + "C.");
        pauseWithDots();
        
        ovenLocked = true;
        System.out.println("\t\tHorno bloqueado.");
    }
    
    public void stopHeat() {
        System.out.println("\t--> Parando horno.");
        pauseWithDots();
        
        ovenLocked = false;
        System.out.println("\t\tHorno desbloqueado.");
    }

    @Override
    public void forceShutOff() {
        if (ovenLocked) {
            stopHeat();
        }
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Oven\t\t[ " + (ovenLocked ? "HEATING" : "RESTING") + " ]";
    }
    
}
