
package robot.command;

import robot.AbsRobotImpl;

public interface Command <D extends AbsRobotImpl> {
    
    public String getActionDescription();
    
    public boolean canExecute(D target);
    
    public void execute(D target);
    
}
