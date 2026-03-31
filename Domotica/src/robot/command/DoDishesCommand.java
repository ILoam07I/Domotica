
package robot.command;

import robot.DishwasherRobot;

public class DoDishesCommand extends AbsCommandImpl <DishwasherRobot> {
    
    private String mode;

    public DoDishesCommand(String mode, DishwasherRobot target) {
        super(target);
        this.mode = mode;
    }

    @Override
    public void execute() {
        target.getRobotExtension().lockRobot();
        target.doDishes(mode);
    }
    
}
