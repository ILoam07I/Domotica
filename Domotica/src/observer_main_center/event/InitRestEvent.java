
package observer_main_center.event;

import robot.command.InitRest;

public class InitRestEvent extends AbsEventImpl <InitRest> {

    public InitRestEvent() {
        super(new InitRest());
    }

    
}
