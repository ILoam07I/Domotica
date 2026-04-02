
package robot.adapter;

import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;
import robot.Robot;

public class RobotAdapter implements EventListener {
    
    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void actualize(Event event) {
        robot.performAction(event.getCommand());
    }
    
}
