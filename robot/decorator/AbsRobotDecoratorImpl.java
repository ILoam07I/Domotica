
package robot.decorator;

import robot.AbsRobotImpl;
import robot.Robot;

public abstract class AbsRobotDecoratorImpl extends AbsRobotImpl {
    
    protected Robot wrappee;

    public AbsRobotDecoratorImpl(Robot wrappee) {
        this.wrappee = wrappee;
    }

    public Robot getWrapee() {
        return wrappee;
    }

    public void setWrapee(Robot wrappee) {
        this.wrappee = wrappee;
    }
    
    

    public <T> T getModule(Class<T> type) {
        
        if (type.isInstance(this)) {
            return type.cast(this);
            
        } else if (wrappee instanceof AbsRobotDecoratorImpl absRobotDecoratorImpl) {
            return absRobotDecoratorImpl.getModule(type);
            
        }
        return null;
    }
   
}
