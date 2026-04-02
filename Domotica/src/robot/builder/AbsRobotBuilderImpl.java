
package robot.builder;

import java.util.List;
import java.util.function.Function;
import observer_main_center.event.Event;
import robot.Robot;

public abstract class AbsRobotBuilderImpl implements RobotBuilder {
    
    protected Robot robot;

    @Override
    public void setCredentials(String model, String id) {
        robot.setModelName(model);
        robot.setId(id);
    }

    @Override
    public void setEvents(List<Event> events) {
        robot.setEvents(events);
    }

    @Override
    public void addDecorator(Function<Robot, Robot> wrapper) {
        wrapper.apply(robot);   //robot -> new AbsRobotDecorator(robot)
    }

    @Override
    public Robot build() {
        return robot;
    }
   
}
