
package robot.command;

import robot.decorator.PowerDecorator;

public class PowerOn extends AbsCommandImpl <PowerDecorator> {

    @Override
    public void execute(PowerDecorator target) {

        if (canExecute(target)) {
            target.turnOn();
        }
    }

    @Override
    public boolean canExecute(PowerDecorator target) {
        return !target.isPowered();
    }

    @Override
    public String getActionDescription() {
        return "Encender.";
    }
    
}
