
package robot.command;

import robot.AbsRobotImpl;

public class ChangeToEcoMode extends AbsCommandImpl {

    @Override
    public void execute(AbsRobotImpl target) {
        target.changeToEcoMode();
    }

    @Override
    public String getActionDescription() {
        return "Cambiar a modo Eco.";
    }
    
}
