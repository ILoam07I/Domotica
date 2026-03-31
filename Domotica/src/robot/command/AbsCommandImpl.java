
package robot.command;

import robot.Robot;

public abstract class AbsCommandImpl <R extends Robot> implements Command <R> {
    
    protected R target;

    public AbsCommandImpl(R target) {
        this.target = target;
    }

}
