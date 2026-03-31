
package facade;

import java.util.List;
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
    
    public void subscribe(Robot robot, List<Class<? extends Event>> types) {
        RobotAdapter robotListener = new RobotAdapter(robot);
        
        for (Class<? extends Event> type : types) {
            hub.register(type, robotListener);
        }
    }
    
}
