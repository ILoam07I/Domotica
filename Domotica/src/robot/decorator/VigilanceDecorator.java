
package robot.decorator;

import robot.Robot;
import robot.command.Command;

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
        wrappee.performAction(command);
    }

    public boolean isVigilant() {
        return vigilant;
    }

    public boolean isRecording() {
        return recording;
    }
    
    public void initVigilanceMode() {
        System.out.print("\t--> Iniciando modo vigilancia " + this.getRobotState().getLaundryParam() + ".");
        pauseWithDots();
        
        vigilant = true;
        System.out.println("\t\tModo vigilancia activado.");
    }
    
    public void initRestMode() {
        System.out.print("\t--> Iniciando modo descanso.");
        pauseWithDots();
        
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
        return wrappee.describe() + "\n\t- Vigilance\t[ " + (vigilant ? "VIGILANT" : "RESTING") + " ]";
    }
    
}
