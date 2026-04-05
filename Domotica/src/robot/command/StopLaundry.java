
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.WashingMachineDecorator;

public class StopLaundry extends AbsCommandImpl <WashingMachineDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        WashingMachineDecorator module = target.getModule(WashingMachineDecorator.class);
        
        if (module != null) {
            
            if (canExecute(module)) {
                module.stopLaundry();

            } else {
                System.out.println("!! Comando " + getActionDescription() + 
                        " No pudo realizarse en: " + target.toString() + " --> Lavadora ya Desbloqueada.");
            }
            
        } else {
            System.out.println("!! Modulo no encontrado para " + getActionDescription());
        }
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
