
package robot.builder;

import robot.InnerRobot;
import robot.Robot;

public abstract class AbsRobotBuilderImpl implements RobotBuilder {
    
    protected Robot robot;

    @Override
    public void reset() {
        robot = new InnerRobot();
    }

    @Override
    public void setCredentials(String model, String id) {
        robot.setModelName(model);
        robot.setId(id);
    }

    @Override
    public Robot build() {
        return robot;
    }
   
}
