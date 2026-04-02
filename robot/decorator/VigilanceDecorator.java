
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
        vigilant = true;
    }
    
    public void initRestMode() {
        vigilant = false;
    }
    
    public void initRecording() {
        recording = true;
    }
    
    public void stopRecording() {
        recording = false;
    }

    @Override
    public void forceShutOff() {
        vigilant = false;
        recording = false;
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Vigilance[ " + (vigilant ? "VIGILANT" : "RESTING") + " ]";
    }
    
}
