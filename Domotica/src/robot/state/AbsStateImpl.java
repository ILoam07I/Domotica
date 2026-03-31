
package robot.state;

public abstract class AbsStateImpl implements State {
    
    protected static final int BATTERY_USAGE = 5;
    
    protected RobotContext robotExtension;
    
    public AbsStateImpl(RobotContext robotExtension) {
        this.robotExtension = robotExtension;
    }
    
}
