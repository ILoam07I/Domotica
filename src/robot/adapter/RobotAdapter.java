
package robot.adapter;

import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;
import robot.Robot;

public class RobotAdapter <E extends Event> implements EventListener <E> {
    
    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void actualize(E event) {
        robot.process(event);
    }
    
}
