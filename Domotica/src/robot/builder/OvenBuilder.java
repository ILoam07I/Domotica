
package robot.builder;

import robot.OvenRobot;

public class OvenBuilder extends AbsRobotBuilderImpl {

    @Override
    public void reset() {
        robot = new OvenRobot();
    }
    
}
