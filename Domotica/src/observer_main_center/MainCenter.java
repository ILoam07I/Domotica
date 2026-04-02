
package observer_main_center;

import java.util.List;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public interface MainCenter {
    
    public List<EventListener> getRobots();
    
    public <E extends Event> void register(Class<E> eventType, EventListener<E> robot);
    
    public <E extends Event> void publish(E event);
    
}
