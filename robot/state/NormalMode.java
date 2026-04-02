
package robot.state;

public class NormalMode extends AbsStateImpl {

    @Override
    public int getOvenTemperatureParam() {
        return 250;
    }

    @Override
    public String getLaundryParam() {
        return "Normal Mode";
    }

    @Override
    public String getNoiseParam() {
        return "Noisy";
    }
    
}
