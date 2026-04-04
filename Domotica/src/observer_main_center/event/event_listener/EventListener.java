
package observer_main_center.event.event_listener;

import observer_main_center.event.Event;
import robot.Robot;

public interface EventListener extends Actionable {
    
    public Robot getRobot();
    
    public <E extends Event> void actualize(E event);
    
}
