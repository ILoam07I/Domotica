
package robot.decorator;

import java.util.Map;
import java.util.function.Consumer;
import observer_main_center.event.Event;
import robot.Robot;

public abstract class AbsRobotDecoratorImpl implements RobotDecorator {
    
    protected Robot wrapee;
    protected Map<Class<? extends Event>, Consumer<Event>> handlers;

    @Override
    public void process(Event event) {
        Consumer<Event> handler = handlers.get(event.getClass());
        
        if (handler != null) {
            handler.accept(event);
        }
        
        wrapee.process(event);
    }

    @Override
    public <E extends Event> void onEvent(Class<E> type, Consumer<E> handler) {
        handlers.put(type, (Consumer<Event>)handler);
    }
    
}
