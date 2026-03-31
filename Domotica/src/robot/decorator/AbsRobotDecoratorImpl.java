
package robot.decorator;

import robot.AbsRobotImpl;
import robot.Robot;

public abstract class AbsRobotDecoratorImpl extends AbsRobotImpl {
    
    protected Robot wrapee;

    public AbsRobotDecoratorImpl(Robot wrapee) {
        this.wrapee = wrapee;
    }

    public Robot getWrapee() {
        return wrapee;
    }

    public void setWrapee(Robot wrapee) {
        this.wrapee = wrapee;
    }
   
}
