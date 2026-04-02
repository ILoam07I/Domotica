
package observer_main_center.event;

import robot.command.StopLaundry;

public class StopLaundryEvent extends AbsEventImpl <StopLaundry> {
    
    public StopLaundryEvent() {
        super(new StopLaundry());
    }
    
}
