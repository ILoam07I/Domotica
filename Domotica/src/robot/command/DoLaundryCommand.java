
package robot.command;

import robot.WashingMachineRobot;

public class DoLaundryCommand extends AbsCommandImpl <WashingMachineRobot> {
    
    private String program;

    public DoLaundryCommand(String program, WashingMachineRobot target) {
        super(target);
        this.program = program;
    }

    @Override
    public void execute() {
        target.getRobotExtension().lockRobot();
        target.doLaundry(program);
    }
    
}
