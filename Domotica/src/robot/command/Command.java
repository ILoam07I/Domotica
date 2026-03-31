
package robot.command;

import robot.Robot;

public interface Command <R extends Robot> {
    
    public void execute();
    
}
