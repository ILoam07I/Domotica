
package robot.command;

import robot.decorator.WashingMachineDecorator;

public class InitLaundry extends AbsCommandImpl <WashingMachineDecorator> {

    @Override
    public void execute(WashingMachineDecorator target) {
        
        if (canExecute(target)) {
            target.initLaundry();
        }
    }

    @Override
    public boolean canExecute(WashingMachineDecorator target) {
        return !target.isWmlocked();
    }

    @Override
    public String getActionDescription() {
        return "Comenzar lavado.";
    }
    
}
