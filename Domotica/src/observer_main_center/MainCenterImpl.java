
package observer_main_center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public class MainCenterImpl implements MainCenter {
    
    private static MainCenterImpl instance;
    
    private Map<Class<? extends Event>, List<EventListener>> listeners;
    private List<EventListener> robots;
    
    private MainCenterImpl() {
        listeners = new HashMap<>();
        robots = new ArrayList<>();
    }
    
    public static MainCenterImpl getInstance() {
        
        if (instance == null) {
            instance = new MainCenterImpl();
        }
        
        return instance;
    }

    @Override
    public List<EventListener> getRobots() {
        return robots;
    }
    
    @Override
    public <E extends Event> void register(Class<E> eventType, EventListener<E> robot) {
        listeners.computeIfAbsent(eventType, e -> new ArrayList<>())
                .add(robot);
        robots.add(robot);
    }
    
    @Override
    public <E extends Event> void publish(E event) {
        List<EventListener> interested = listeners.getOrDefault(event.getClass(), Collections.emptyList());
        
        for (EventListener<? extends Event> listener : interested) {
            ((EventListener<E>)listener).actualize(event);
        }
    }
    
}
