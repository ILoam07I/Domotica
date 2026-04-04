
package observer_main_center.event.event_listener;

import java.util.List;
import java.util.Set;
import observer_main_center.event.Event;

public interface Actionable {
    
    public Set<? extends Event> getActions();
    
    public <E extends Event> void initAction(E event);
    
    public List<EventListener> getSubject();
    
    public void add(EventListener robot);
    
    public void remove(EventListener robot);
    
}
