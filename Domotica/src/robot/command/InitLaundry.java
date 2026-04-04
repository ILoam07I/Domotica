
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.WashingMachineDecorator;

public class InitLaundry extends AbsCommandImpl <WashingMachineDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        WashingMachineDecorator module = target.getModule(WashingMachineDecorator.class);
        
        if (canExecute(module)) {
            module.initLaundry();
            
        } else {
            System.out.println("!! Comando " + getActionDescription() + 
                    " No pudo realizarse en: " + target.toString() + " --> Lavadora ya Bloqueada.");
        }
    }

    @Override
    public boolean canExecute(WashingMachineDecorator module) {
        return !module.isWmlocked();
    }

    @Override
    public String getActionDescription() {
        return "[init_laundry] Comenzar lavado.";
    }
    
}
