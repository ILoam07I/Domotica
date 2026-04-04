
package robot.command;

import robot.AbsRobotImpl;

public class ChangeToNormalMode extends AbsCommandImpl {

    @Override
    public void execute(AbsRobotImpl target) {
        target.changeToNormalMode();
    }

    @Override
    public String getActionDescription() {
        return "[normal] Cambiar a modo Normal.";
    }
    
}
