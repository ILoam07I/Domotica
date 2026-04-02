
package robot.command;

import robot.AbsRobotImpl;

public class ChangeToNightMode extends AbsCommandImpl {

    @Override
    public void execute(AbsRobotImpl target) {
        target.changeToNightMode();
    }

    @Override
    public String getActionDescription() {
        return "Cambiar a modo Noche.";
    }
    
}
