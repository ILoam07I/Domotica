
package robot.state;

public class LockedState extends AbsStateImpl {

    public LockedState(RobotContext robotExtension) {
        super(robotExtension);
    }

    @Override
    public boolean canHandleCommand() {
        return false;
    }

    @Override
    public int handleBattery() {
        return 0;
    }

    @Override
    public void lock() {}

    @Override
    public void release() {
        robotExtension.setRobotState(new IdleState(robotExtension));
    }
   
}
