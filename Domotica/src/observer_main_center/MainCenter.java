
package observer_main_center;

import java.util.List;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public interface MainCenter {

    public <E extends Event> boolean register(EventListener robot, List<? extends Event> events);
    
    public boolean unregister(EventListener robot);
    
    public <E extends Event> void publish(E event);
    
}
