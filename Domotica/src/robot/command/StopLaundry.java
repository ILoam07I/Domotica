
package robot.command;

import robot.decorator.WashingMachineDecorator;

public class StopLaundry extends AbsCommandImpl <WashingMachineDecorator> {

    @Override
    public void execute(WashingMachineDecorator target) {
        
        if (canExecute(target)) {
            target.stopLaundry();
        }
    }

    @Override
    public boolean canExecute(WashingMachineDecorator target) {
        return target.isWmlocked();
    }

    @Override
    public String getActionDescription() {
        return "[stop_laundry] Parar lavado.";
    }
    
}
