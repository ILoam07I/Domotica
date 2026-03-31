
package robot.decorator.strategy;

public class SavingUsageBehavior implements BatteryMode {

    @Override
    public int calculateBatteryUsage(int baseUsage) {
        return (int)(baseUsage * RANDOM.nextDouble(0.5, 1.5));
    }
    
}
