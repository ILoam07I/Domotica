
package robot.builder;

import java.util.List;
import java.util.function.Function;
import observer_main_center.event.Event;
import robot.Robot;

public interface RobotBuilder {
    
    public void reset();
    
    public void setCredentials(String model, String id);
    
    public void setEvents(List<Event> events);
    
    public void addDecorator(Function<Robot, Robot> wrapper);
    
    public Robot build();

}
