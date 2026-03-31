
package robot.builder;

import robot.GenericRobot;

public class GenericBuilder extends AbsRobotBuilderImpl {

    @Override
    public void reset() {
        robot = new GenericRobot();
    }
    
}
