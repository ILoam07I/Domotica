
package observer_main_center.event;

import robot.command.InitVigilance;

public class InitVigilanceEvent extends AbsEventImpl <InitVigilance> {

    public InitVigilanceEvent() {
        super(new InitVigilance());
    }

    
}
