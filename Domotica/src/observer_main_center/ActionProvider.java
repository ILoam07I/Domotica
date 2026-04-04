
package observer_main_center;

import java.util.Set;
import observer_main_center.event.Event;

public interface ActionProvider {
    
    public Set<? extends Event> getActions();
    
}
