
package robot.command;

import robot.AbsRobotImpl;
import robot.decorator.VigilanceDecorator;

public class InitRest extends AbsCommandImpl <VigilanceDecorator> {

    @Override
    public void execute(AbsRobotImpl target) {
        VigilanceDecorator module = target.getModule(VigilanceDecorator.class);
        
        if (canExecute(module)) {
            module.initRestMode();
            
        } else {
            System.out.println("!! Comando " + getActionDescription() + 
                    " No pudo realizarse en: " + target.toString() + " --> Ya en Modo Descanso.");
        }
    }

    @Override
    public boolean canExecute(VigilanceDecorator module) {
        return module.isVigilant();
    }

    @Override
    public String getActionDescription() {
        return "[rest] Activar descanso.";
    }
    
}
