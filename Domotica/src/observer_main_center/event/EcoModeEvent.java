
package observer_main_center.event;

import robot.command.ChangeToEcoMode;

public class EcoModeEvent extends AbsEventImpl <ChangeToEcoMode> {
    
    public EcoModeEvent() {
        super(new ChangeToEcoMode());
    }
    
}
