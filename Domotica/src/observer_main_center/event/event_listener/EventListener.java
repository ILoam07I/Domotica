
package observer_main_center.event.event_listener;

import observer_main_center.ActionProvider;
import observer_main_center.event.Event;
import robot.Robot;

public interface EventListener extends ActionProvider {
    
    public Robot getRobot();
    
    public <E extends Event> void actualize(E event);
    
    @Override
    public boolean equals(Object o);
    @Override
    public int hashCode();
    @Override
    public String toString();
    
}
