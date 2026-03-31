
package robot.builder;

import robot.Robot;
import robot.decorator.PowerDecorator;

public class Director {
    
    private RobotBuilder builder;
    
    public Robot buildSmartWashingMachine(String model, String id) {
        builder = new WashingMachineBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(PowerDecorator::new);  //robot -> new PowerDecorator(robot)
        return builder.build();
    }
    
    
}
