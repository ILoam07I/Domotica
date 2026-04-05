
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.VigilanceDecorator;

public class InitVigilance extends AbsCommandImpl <VigilanceDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        VigilanceDecorator module = target.getModule(VigilanceDecorator.class);
        
        if (module != null) {
            if (canExecute(module)) {
                module.initVigilanceMode();

            } else {
                System.out.println("!! Comando " + getActionDescription() + 
                        " No pudo realizarse en: " + target.toString() + " --> Ya en Modo Vigilancia.");
            }
            
        } else {
            System.out.println("!! Modulo no encontrado para " + getActionDescription());
        }
    }

    @Override
    public boolean canExecute(VigilanceDecorator module) {
        return !module.isVigilant();
    }

    @Override
    public String getActionDescription() {
        return "[vigilance] Activar vigilancia.";
    }
    
}
