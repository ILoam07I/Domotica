
package robot.command;

import robot.AbsRobotImpl;

public interface Command <D extends AbsRobotImpl> {
    
    /*  En nuestro caso, los comandos contienen un poco de lógica de negocio, se podria haber
        delegado a una clase Receiver, pero aprovechamos que los comandos están ya acoplados
        a un decorador concreto.
    */
    public String getActionDescription();
    
    public boolean canExecute(D target);
    
    public void execute(D target);
    
}
