
package robot;

import java.util.List;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.state.State;

public interface Robot {
    
    public String getModelName();
    public void setModelName(String model);
    
    public String getId();
    public void setId(String id);
    
    public List<Event> getEvents();
    public void setEvents(List<Event> getEvents);
    
    public State getRobotState();    
    public void changeToEcoMode();
    public void changeToNightMode();
    public void changeToNormalMode();
    
    //  Implementaciones de Chain of Responsibility.
    public void performAction(Command command);
    public void forceShutOff();
    public String describe();

}
