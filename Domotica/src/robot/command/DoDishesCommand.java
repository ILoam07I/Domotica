
package robot.command;

import java.util.ArrayList;
import robot.DishwasherRobot;

public class DoDishesCommand extends AbsCommandImpl <DishwasherRobot> {
    
    private String mode;

    public DoDishesCommand(String mode) {
        target = new ArrayList<>();
        this.mode = mode;
    }

    @Override
    public void execute() {
        
        for (DishwasherRobot robot : target) {
            robot.getRobotExtension().lockRobot();
            robot.doDishes(mode);
        }
    }
    
}
