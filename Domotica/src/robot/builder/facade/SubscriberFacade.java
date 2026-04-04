
package robot.builder.facade;

import observer_main_center.MainCenter;
import observer_main_center.MainCenterImpl;
import robot.Robot;
import robot.adapter.RobotAdapter;

public class SubscriberFacade {
    
    private MainCenter hub;

    public SubscriberFacade() {
        hub = MainCenterImpl.getInstance();
    }
    
    public boolean subscribe(Robot robot) {
        RobotAdapter robotListener = new RobotAdapter(robot);

        return hub.register(robotListener, robot.getEvents());
    }
    
}
