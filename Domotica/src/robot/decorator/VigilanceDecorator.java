
package robot.decorator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import observer_main_center.event.Event;
import observer_main_center.event.HomeAloneEvent;
import observer_main_center.event.HomeGuardedEvent;
import robot.Robot;

public class VigilanceDecorator extends AbsRobotDecoratorImpl {

    private final Map<Class<? extends Event>, Consumer<Event>> handlers = new HashMap<>();
    private boolean vigilance;

    public VigilanceDecorator(Robot wrapee) {
        super(wrapee);
        this.vigilance = false;
        
        initHandlers();
    }

    public boolean isVigilance() {
        return vigilance;
    }
    
    public void initHandlers() {
        handlers.put(HomeAloneEvent.class, e -> initVigilanceMode());
        handlers.put(HomeGuardedEvent.class, e -> initRestMode());
    }

    @Override
    public void performAction(Event event) {
        Consumer<Event> handler = handlers.get(event.getClass());
        
        if (handler != null) {
            handler.accept(event);
        }
         
        wrapee.performAction(event);
    }
    
    public void initVigilanceMode() {
        vigilance = true;
    }
    
    public void initRestMode() {
        vigilance = false;
    }
    
}
