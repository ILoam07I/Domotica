
package robot.builder.facade;

import java.util.List;
import java.util.Set;
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
    
    public boolean subscribe(Robot robot, List<? extends Event> events) {
        RobotAdapter robotListener = new RobotAdapter(robot, Set.copyOf(events));

        return hub.register(robotListener, events);
    }
    
}
