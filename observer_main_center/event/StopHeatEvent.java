
package observer_main_center.event;

import robot.command.StopHeat;

public class StopHeatEvent extends AbsEventImpl <StopHeat> {
    
    public StopHeatEvent() {
        super(new StopHeat());
    }
    
}
