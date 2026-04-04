
package observer_main_center;

import observer_main_center.event.Event;
import observer_main_center.event.event_listener.Actionable;
import observer_main_center.event.event_listener.EventListener;

public interface MainCenter extends Actionable {

    public <E extends Event> void register(E event, EventListener robot);
    
    public <E extends Event> void publish(E event);
    
}
