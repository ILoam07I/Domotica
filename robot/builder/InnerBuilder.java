
package robot.builder;

import robot.InnerRobot;

public class InnerBuilder extends AbsRobotBuilderImpl {

    @Override
    public void reset() {
        robot = new InnerRobot();
    }
    
}
