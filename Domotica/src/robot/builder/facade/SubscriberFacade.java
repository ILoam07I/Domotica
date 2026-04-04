
package robot.builder.facade;

import observer_main_center.MainCenter;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.Event;
import robot.Robot;
import robot.adapter.RobotAdapter;

public class SubscriberFacade {
    
    private MainCenter hub;

    public SubscriberFacade() {
        hub = MainCenterImpl.getInstance();
    }
    
    public void subscribe(Robot robot) {
        RobotAdapter robotListener = new RobotAdapter(robot);
        
        for (Event event : robot.getEvents()) {
            hub.register(event, robotListener);
        }
    }
    
}
