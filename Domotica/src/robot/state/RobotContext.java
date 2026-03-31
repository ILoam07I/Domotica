
package robot.state;

public class RobotContext {
    
    private State robotState;

    public RobotContext() {
        this.robotState = new IdleState(this);
    }

    public void setRobotState(State robotState) {
        this.robotState = robotState;
    }
    
    public int getBatteryUsage() {
        return robotState.handleBattery();
    }
    
    public void lockRobot() {
        robotState.lock();
    }
     
    public void releaseRobot() {
        robotState.release();
    }
    
    public boolean isLocked() {
        return robotState.canHandleCommand();
    }
    
}
