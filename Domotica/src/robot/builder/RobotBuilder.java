
package robot.builder;

import robot.Robot;

public interface RobotBuilder {
    
    public void reset();
    
    public void setCredentials(String model, String id);
    
    public void setEvents();
    
    public void addDecorator();
    
    public Robot build();

}
