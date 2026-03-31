
package robot.command;

import java.util.ArrayList;
import robot.OvenRobot;

public class StartOvenCommand extends AbsCommandImpl <OvenRobot> {
    
    private int temperature;

    public StartOvenCommand(int temperature) {
        target = new ArrayList<>();
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        
        for (OvenRobot robot : target) {
            robot.getRobotExtension().lockRobot();
            robot.heat(temperature);
        }
    }
    
}
