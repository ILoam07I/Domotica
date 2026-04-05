
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.PowerDecorator;

public class PowerOff extends AbsCommandImpl <PowerDecorator> {
    
    @Override
    public void execute(AbsRobotImpl target) {
        PowerDecorator module = target.getModule(PowerDecorator.class);
        
        if (module != null) {
            if (canExecute(module)) {
                module.forceShutOff();

            } else {
                System.out.println("!! Comando " + getActionDescription() + 
                        " No pudo realizarse en: " + target.toString() + " --> Ya Apagado.");
            }
            
        } else {
            System.out.println("!! Modulo no encontrado para " + getActionDescription());
        }
    }

    @Override
    public boolean canExecute(PowerDecorator module) {
        return module.isPowered();
    }

    @Override
    public String getActionDescription() {
        return "[off] Apagar.";
    }
    
}
