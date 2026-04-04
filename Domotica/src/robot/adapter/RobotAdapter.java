
package robot.adapter;

import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;
import robot.Robot;
import robot.command.Command;

public class RobotAdapter implements EventListener {
    
    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Robot getRobot() {
        return robot;
    }

    @Override
    public <E extends Event> void actualize(E event) {
        
        if (robot.getEvents().contains(event)) {
            System.out.println(robot.toString() + "  -- Iniciando acciones: ");

            for (Command command : event.getCommands()) {
                
                robot.performAction(command);
            }
        }
    }

    @Override
    public Set<? extends Event> getActions() {
        return Set.copyOf(robot.getEvents());
    }
    
    @Override
    public boolean equals(Object o) {
        EventListener adapter = (EventListener) o;
        
        return this.robot.equals(adapter.getRobot());
    }
    
    @Override
    public int hashCode() {
        return robot.hashCode();
    }
    
    @Override
    public String toString() {
        return robot.toString();
    }
    
}
