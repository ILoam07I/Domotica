
package robot.decorator;

import observer_main_center.event.Event;
import robot.Robot;

//Último decorador siempre = primera capa de la seboya!!!
public class PowerDecorator extends AbsRobotDecoratorImpl {
    
    private boolean powered;

    public PowerDecorator(Robot wrapee) {
        super(wrapee);
        this.powered = false;
    }

    public boolean isPowered() {
        return powered;
    }

    @Override
    public void performAction(Event event) {
        
        if (powered) {
            wrappee.performAction(event);
        }       
    }
    
    public void turnOn() {
        powered = true;
    }
    
    public void turnOff() {
        robotExtension.releaseRobot();
        powered = false;
    }
    
}
