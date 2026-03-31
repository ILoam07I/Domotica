
package observer_main_center.event;

import robot.Robot;

public abstract class AbsEventImpl implements Event {
    
    protected Robot robot;
    
    public AbsEventImpl(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }
    
}
