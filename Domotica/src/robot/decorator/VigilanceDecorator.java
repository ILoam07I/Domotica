
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.command.InitRest;
import robot.command.InitVigilance;

public class VigilanceDecorator extends AbsRobotDecoratorImpl {

    private boolean vigilant;
    private boolean recording;

    public VigilanceDecorator(Robot wrapee) {
        super(wrapee);
        this.vigilant = false;
        this.recording = false;
    }

    @Override
    public void performAction(Command command) {
        if (command.getClass() == InitVigilance.class) {
            command.execute(this);
            
        } else if (command.getClass() == InitRest.class) {
            command.execute(this);
            
        } else {
            wrappee.performAction(command);
        }
    }

    public boolean isVigilant() {
        return vigilant;
    }

    public boolean isRecording() {
        return recording;
    }
    
    public void initVigilanceMode() {
        System.out.println("\t--> Iniciando modo vigilancia " + robotState.getLaundryParam() + ".");
        
        vigilant = true;
        System.out.println("\t\tModo vigilancia activado.");
    }
    
    public void initRestMode() {
        System.out.println("\t--> Iniciando modo descanso.");
        
        vigilant = false;
        System.out.println("\t\tModo descanso activado.");
    }
    
    public void initRecording() {
        recording = true;
    }
    
    public void stopRecording() {
        recording = false;
    }

    @Override
    public void forceShutOff() {
        if (vigilant) {
            initRestMode();
        }
        if (recording) {
            stopRecording();
        }
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Vigilance[ " + (vigilant ? "VIGILANT" : "RESTING") + " ]";
    }
    
}
