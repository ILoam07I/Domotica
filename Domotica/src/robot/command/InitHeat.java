
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.OvenDecorator;

public class InitHeat extends AbsCommandImpl <OvenDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {       
        OvenDecorator ovenModule = target.getModule(OvenDecorator.class);
        
        if (ovenModule != null) {
            
            if (canExecute(ovenModule)) {
                ovenModule.initHeat();

            } else {
                System.out.println("!! Comando " + getActionDescription() + 
                        " No pudo realizarse en: " + target.toString() + " --> Horno ya Bloqueado.");
            }
            
        } else {
            System.out.println("!! Modulo no encontrado para " + getActionDescription());
        }
    }

    @Override
    public boolean canExecute(OvenDecorator module) {
        return !module.isOvenLocked();
    }

    @Override
    public String getActionDescription() {
        return "[init_heat] Encender horno.";
    }
    
}
