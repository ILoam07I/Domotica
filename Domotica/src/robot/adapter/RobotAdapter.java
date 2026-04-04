
package robot.adapter;

import java.util.List;
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
        System.out.println(robot.toString() + "  -- Iniciando acciones: ");
        
        for (Command command : event.getCommands()) {
            robot.performAction(command);
        }       
    }

    @Override
    public Set<? extends Event> getActions() {
        return Set.copyOf(robot.getEvents());
    }

    @Override
    public <E extends Event> void initAction(E event) {
        actualize(event);
    }

    @Override
    public List<EventListener> getSubject() {
        return List.of(this);
    }

    @Override
    public void add(EventListener robot) {}

    @Override
    public void remove(EventListener robot) {}
    
}
