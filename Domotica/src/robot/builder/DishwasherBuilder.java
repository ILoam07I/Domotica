
package robot.builder;

import robot.DishwasherRobot;

public class DishwasherBuilder extends AbsRobotBuilderImpl {

    @Override
    public void reset() {
        robot = new DishwasherRobot();
    }

    
}
