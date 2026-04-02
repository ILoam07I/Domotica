
package observer_main_center.event;

import robot.command.ChangeToNightMode;

public class NightModeEvent extends AbsEventImpl <ChangeToNightMode> {
    
    public NightModeEvent() {
        super(new ChangeToNightMode());
    }
    
}
