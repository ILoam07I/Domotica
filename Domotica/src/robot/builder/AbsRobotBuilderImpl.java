
package robot.builder;

import java.util.function.Function;
import robot.Robot;
import robot.state.RobotContext;

public abstract class AbsRobotBuilderImpl implements RobotBuilder {
    
    protected Robot robot;

    @Override
    public void setCredentials(String model, String id) {
        robot.setModelName(model);
        robot.setId(id);
    }

    @Override
    public void setRobotExtension() {
        robot.setRobotExtension(new RobotContext());
    }

    @Override
    public void addDecorator(Function<Robot, Robot> wrapper) {
        wrapper.apply(robot);
    }

    @Override
    public Robot build() {
        return robot;
    }
   
}
