
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.WashingMachineDecorator;

public class StopLaundry extends AbsCommandImpl <WashingMachineDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        WashingMachineDecorator module = target.getModule(WashingMachineDecorator.class);
        
        if (canExecute(module)) {
            module.stopLaundry();
            
        } System.out.println("!! Comando " + getActionDescription() + 
                    " No pudo realizarse en: " + target.toString() + " --> Lavadora ya Desbloqueada.");
    }

    @Override
    public boolean canExecute(WashingMachineDecorator module) {
        return module.isWmlocked();
    }

    @Override
    public String getActionDescription() {
        return "[stop_laundry] Parar lavado.";
    }
    
}
