
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.command.InitHeat;
import robot.command.StopHeat;

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
        if (command.getClass() == InitHeat.class) {
            command.execute(this);
            
        } else if (command.getClass() == StopHeat.class) {
            command.execute(this);
            
        } else {
            wrappee.performAction(command);
        }
    }  
       
    public void initHeat() {
        System.out.println("\t--> Empezando a calentar a " + robotState.getOvenTemperatureParam() + "ºC.");
        
        ovenLocked = true;
        System.out.println("\t\tHorno bloqueado.");
    }
    
    public void stopHeat() {
        System.out.println("\t--> Parando horno.");
        
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
        return wrappee.describe() + "\n\t- Oven[ " + (ovenLocked ? "HEATING" : "RESTING") + " ]";
    }
    
}
