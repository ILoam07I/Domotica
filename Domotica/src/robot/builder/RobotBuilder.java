
package robot.builder;

import java.util.function.Function;
import robot.Robot;

public interface RobotBuilder {
    
    public void reset();
    
    public void setCredentials(String model, String id);
    
    public void setRobotExtension();
    
    public void addDecorator(Function<Robot, Robot> wrapper);
    
    public Robot build();

}
