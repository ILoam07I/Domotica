
package robot.decorator.strategy;

public class NormalUsageBehavior implements BatteryMode {

    @Override
    public int calculateBatteryUsage(int baseUsage) {
        return (int)(baseUsage * RANDOM.nextDouble(1.0, 2.0));
    }
    
}
