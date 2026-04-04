
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.decorator.strategy.BatteryMode;
import robot.decorator.strategy.NormalUsageBehavior;
import robot.decorator.strategy.SavingUsageBehavior;

public class BatteryDecorator extends AbsRobotDecoratorImpl {
    
    private static final int TRESHOLD = 20;
    private static final int USAGE = 5;
    
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
        int usage = batteryStrategy.calculateBatteryUsage(USAGE);
        
        if (usage < batteryLevel) {
            batteryLevel -= usage;
            
            if (batteryLevel <= TRESHOLD) {
                batteryStrategy = new SavingUsageBehavior();
                System.out.println("\t\t!! Bateria baja, activando Ahorro de Bateria.");
            }
            
            wrappee.performAction(command);
            
        } else {
            System.out.println("\t\t!! Bateria muy baja, no se pudo realizar la accion.");
            charge();
        }
    }
    
    public void charge() {
        System.out.print("\t\t!! Recargando bateria.");
        pauseWithDots();
        
        batteryLevel = 100;
        System.out.println("\t\tBateria recargada.");
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
        return wrappee.describe() + "\n\t- Battery\t[ " + batteryLevel + "% ]";
    }

}
