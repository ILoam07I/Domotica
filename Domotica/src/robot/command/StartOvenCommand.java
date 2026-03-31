
package robot.command;

import robot.OvenRobot;

public class StartOvenCommand extends AbsCommandImpl <OvenRobot> {
    
    private int temperature;

    public StartOvenCommand(int temperature, OvenRobot target) {
        super(target);
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        target.heat(temperature);
    }
    
}
