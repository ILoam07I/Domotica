
package robot.command;

import robot.decorator.VigilanceDecorator;

public class InitVigilance extends AbsCommandImpl <VigilanceDecorator> {

    @Override
    public void execute(VigilanceDecorator target) {
        
        if (canExecute(target)) {
            target.initVigilanceMode();
        }
    }

    @Override
    public boolean canExecute(VigilanceDecorator target) {
        return !target.isVigilant();
    }

    @Override
    public String getActionDescription() {
        return "Activar vigilancia.";
    }
    
}
