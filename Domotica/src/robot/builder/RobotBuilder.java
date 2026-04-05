
package robot.builder;

import java.util.List;
import observer_main_center.event.Event;
import robot.Robot;

public interface RobotBuilder {
    
    public void reset();
    
    public void setCredentials(String model, String id);
    
    public void addDecorator();
    
    public Robot build();

    public List<? extends Event> getEvents();
}
