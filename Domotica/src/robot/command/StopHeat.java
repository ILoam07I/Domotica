
package robot.command;

import robot.decorator.OvenDecorator;

public class StopHeat extends AbsCommandImpl <OvenDecorator> {

    @Override
    public void execute(OvenDecorator target) {
        
        if (canExecute(target)) {
            target.stopHeat();
        }
    }

    @Override
    public boolean canExecute(OvenDecorator target) {
        return target.isOvenLocked();
    }

    @Override
    public String getActionDescription() {
        return "Parar horno.";
    }
    
}
