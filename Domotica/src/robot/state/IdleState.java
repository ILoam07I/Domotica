
package robot.state;

public class IdleState extends AbsStateImpl {

    public IdleState(RobotContext robotExtension) {
        super(robotExtension);
    }

    @Override
    public boolean canHandleCommand() {
        return true;
    }

    @Override
    public int handleBattery() {
        return AbsStateImpl.BATTERY_USAGE;
    }

    @Override
    public void lock() {
        robotExtension.setRobotState(new LockedState(robotExtension));
    }

    @Override
    public void release() {}
   
}
