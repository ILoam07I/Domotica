
package robot.command;

import java.util.List;
import robot.Robot;

public abstract class AbsCommandImpl <R extends Robot> implements Command <R> {
    
    protected List<R> target;

}
