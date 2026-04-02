
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.decorator.strategy.BatteryMode;
import robot.decorator.strategy.NormalUsageBehavior;
import robot.decorator.strategy.SavingUsageBehavior;

public class BatteryDecorator extends AbsRobotDecoratorImpl {
    
    private static final int TRESHOLD = 20;
    
    private int batteryLevel;
    private BatteryMode batteryStrategy;

    public BatteryDecorator(Robot wrappee) {
        super(wrappee);
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
    public void performAction(Command command) {
        int usage = batteryStrategy.calculateBatteryUsage(5);
        
        if (usage < batteryLevel) {
            batteryLevel -= usage;
            
            if (batteryLevel <= TRESHOLD) {
                batteryStrategy = new SavingUsageBehavior();
            }
            
            wrappee.performAction(command);
        }       
    }
    
    public void charge() {
        batteryLevel = 100;
        batteryStrategy = new NormalUsageBehavior();
    }

    @Override
    public void forceShutOff() {
        
        if (batteryLevel <= TRESHOLD) {
            charge();
        }
        
        wrappee.forceShutOff();
    }

    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Battery[ " + batteryLevel + "% ]";
    }

}
