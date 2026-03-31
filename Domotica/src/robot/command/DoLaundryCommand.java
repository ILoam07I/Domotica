
package robot.command;

import java.util.ArrayList;
import robot.WashingMachineRobot;

public class DoLaundryCommand extends AbsCommandImpl <WashingMachineRobot> {
    
    private String program;

    public DoLaundryCommand(String program) {
        target = new ArrayList<>();
        this.program = program;
    }

    @Override
    public void execute() {
        for (WashingMachineRobot robot : target) {
            robot.getRobotExtension().lockRobot();
            robot.doLaundry(program);
        }
    }
    
}
