
package robot.decorator;

import robot.Robot;
import robot.command.Command;
import robot.command.PowerOff;
import robot.command.PowerOn;

public class PowerDecorator extends AbsRobotDecoratorImpl {
    
    private boolean powered;

    public PowerDecorator(Robot wrapee) {
        super(wrapee);
        this.powered = false;
    }

    public boolean isPowered() {
        return powered;
    }
    
    public void turnOn() {
        System.out.print("\t--> Iniciando secuencia de arranque.");
        pauseWithDots();
        
        powered = true;
        System.out.println("\t\tEncendido.");
    }

    @Override
    public void performAction(Command command) {
        
        if (powered) {           
            if (command.getClass() == PowerOff.class) {
                command.execute(this);
                
            } else {
                wrappee.performAction(command);
            }
            
        } else {
            if (command.getClass() == PowerOn.class) {
                command.execute(this);
                
            } else {
                System.out.println("\t\t!! El robot esta apagado. Debe encenderse primero.");
            }
        }    
    }

    @Override
    public void forceShutOff() {
        System.out.print("\t--> Iniciando secuencia de apagado.");
        pauseWithDots();
        
        powered = false;
        wrappee.forceShutOff();
    }
    
    @Override
    public String describe() {
        return wrappee.describe() + "\n\t- Power\t\t[ " + (powered ? "ON" : "OFF") + " ]";
    }
    
}
