
package robot.state;

public class EcoMode extends AbsStateImpl {

    @Override
    public int getOvenTemperatureParam() {
        return 200;
    }

    @Override
    public String getLaundryParam() {
        return "Eco Mode";
    }

    @Override
    public String getNoiseParam() {
        return "Noisy";
    }
    
}
