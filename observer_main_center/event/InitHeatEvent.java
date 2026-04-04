
package observer_main_center.event;

import robot.command.InitHeat;

public class InitHeatEvent extends AbsEventImpl <InitHeat> {
    
    public InitHeatEvent() {
        super(new InitHeat());
    }
    
}
