
package observer_main_center.event;

import robot.command.PowerOff;

public class PowerOffEvent extends AbsEventImpl <PowerOff> {
    
    public PowerOffEvent() {
        super(new PowerOff());
    }
    
}
