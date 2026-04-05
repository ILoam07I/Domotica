
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.OvenDecorator;

public class StopHeat extends AbsCommandImpl <OvenDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        OvenDecorator module = target.getModule(OvenDecorator.class);
                
        if (module != null) {
            
            if (canExecute(module)) {
                module.stopHeat();

            } else {
                System.out.println("!! Comando " + getActionDescription() + 
                        " No pudo realizarse en: " + target.toString() + " --> Horno ya Desbloqueado.");
            }
            
        } else {
            System.out.println("!! Modulo no encontrado para " + getActionDescription());
        }
    }

    @Override
    public boolean canExecute(OvenDecorator module) {
        return module.isOvenLocked();
    }

    @Override
    public String getActionDescription() {
        return "[stop_heat] Parar horno.";
    }
    
}
