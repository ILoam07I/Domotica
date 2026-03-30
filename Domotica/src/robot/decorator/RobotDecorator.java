
package robot.decorator;

import java.util.function.Consumer;
import observer_main_center.event.Event;
import robot.Robot;

public interface RobotDecorator extends Robot {
    
    public void registerHandler();
    
    public <E extends Event> void onEvent(Class<E> type, Consumer<E> handler);
    
}
