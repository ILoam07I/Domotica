
package robot;

import observer_main_center.event.Event;
import robot.state.RobotContext;

public interface Robot {
    
    public String getModelName();
    public void setModelName(String model);
    
    public String getId();
    public void setId(String id);
    
    public RobotContext getRobotExtension();
    public void setRobotExtension(RobotContext robotExtension);
    
    public void performAction(Event event);
    
}
