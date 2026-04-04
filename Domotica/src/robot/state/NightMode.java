
package robot.state;

public class NightMode extends AbsStateImpl {

    @Override
    public int getOvenTemperatureParam() {
        return 250;
    }

    @Override
    public String getLaundryParam() {
        return "Night Mode";
    }

    @Override
    public String getNoiseParam() {
        return "Quietly";
    }

    
}
