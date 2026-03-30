
package robot;

import observer_main_center.event.Event;

public interface Robot {
    
    public boolean addFunctionality(Robot functionality);
    
    public void process(Event event);
    
}
