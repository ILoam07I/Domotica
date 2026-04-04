
package robot.decorator.strategy;

public class NormalUsageBehavior implements BatteryMode {

    @Override
    public int calculateBatteryUsage(int baseUsage) {
        return (int)(baseUsage * RANDOM.nextDouble(2.0, 4.0));
    }
    
}
