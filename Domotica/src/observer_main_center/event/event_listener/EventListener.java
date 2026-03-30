
package observer_main_center.event.event_listener;

import observer_main_center.event.Event;

@FunctionalInterface
public interface EventListener <E extends Event> {
    
    public void actualize(E event);
    
}
