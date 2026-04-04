
package robot.command;

import robot.decorator.OvenDecorator;

public class InitHeat extends AbsCommandImpl <OvenDecorator> {

    @Override
    public void execute(OvenDecorator target) {
        
        if (canExecute(target)) {
            target.initHeat();
        }
    }

    @Override
    public boolean canExecute(OvenDecorator target) {
        return !target.isOvenLocked();
    }

    @Override
    public String getActionDescription() {
        return "[init_heat] Encender horno.";
    }
    
}
