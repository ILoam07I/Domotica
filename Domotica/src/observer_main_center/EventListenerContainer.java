
package observer_main_center;

import java.util.List;
import observer_main_center.event.event_listener.EventListener;

public interface EventListenerContainer {
    
    public List<EventListener> getSubject();
    
}
