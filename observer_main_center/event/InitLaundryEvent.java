
package observer_main_center.event;

import robot.command.InitLaundry;

public class InitLaundryEvent extends AbsEventImpl <InitLaundry> {
    
    public InitLaundryEvent() {
        super(new InitLaundry());
    }
    
}
