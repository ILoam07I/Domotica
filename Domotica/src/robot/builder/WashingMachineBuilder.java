
package robot.builder;

import robot.WashingMachineRobot;

public class WashingMachineBuilder extends AbsRobotBuilderImpl {

    @Override
    public void reset() {
        robot = new WashingMachineRobot();
    }
    
}
