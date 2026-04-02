
package observer_main_center.event;

import robot.command.PowerOn;

public class PowerOnEvent extends AbsEventImpl <PowerOn> {
    
    public PowerOnEvent() {
        super(new PowerOn());
    }
    
}
