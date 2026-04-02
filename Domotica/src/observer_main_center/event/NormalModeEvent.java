
package observer_main_center.event;

import robot.command.ChangeToNormalMode;

public class NormalModeEvent extends AbsEventImpl <ChangeToNormalMode> {
    
    public NormalModeEvent() {
        super(new ChangeToNormalMode());
    }
    
}
