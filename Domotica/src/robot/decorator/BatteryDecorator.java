
package robot.decorator;

import observer_main_center.event.Event;
import robot.Robot;
import robot.decorator.strategy.BatteryMode;
import robot.decorator.strategy.NormalUsageBehavior;
import robot.decorator.strategy.SavingUsageBehavior;

public class BatteryDecorator extends AbsRobotDecoratorImpl {
    
    private static final int TRESHOLD = 20;
    
    private int batteryLevel;
    private BatteryMode batteryStrategy;

    public BatteryDecorator(Robot wrapee) {
        super(wrapee);
        this.batteryLevel = 100;
        batteryStrategy = new NormalUsageBehavior();
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public BatteryMode getBatteryStrategy() {
        return batteryStrategy;
    }
    
    @Override
    public void performAction(Event event) {
        int usage = batteryStrategy.calculateBatteryUsage(robotExtension.getBatteryUsage());
        
        if (usage < batteryLevel) {
            batteryLevel -= usage;
            
            if (batteryLevel <= TRESHOLD) {
                batteryStrategy = new SavingUsageBehavior();
            }            
        }       
    }
    
    public void charge() {
        batteryLevel = 100;
        batteryStrategy = new NormalUsageBehavior();
    }

}
