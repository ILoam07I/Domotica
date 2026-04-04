
package robot.decorator.strategy;

import java.util.Random;

public interface BatteryMode {
    
    public static final Random RANDOM = new Random();
    
    public int calculateBatteryUsage(int baseUsage);
    
}
