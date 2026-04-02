
package robot.command;

import robot.AbsRobotImpl;

public abstract class AbsCommandImpl <D extends AbsRobotImpl> implements Command <D> {
    
    @Override
    public boolean canExecute(D target) {
        return true;
    }
    
}
