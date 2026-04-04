
package observer_main_center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public class MainCenterImpl implements MainCenter {
    
    private static MainCenterImpl instance;
    
    private Map<Event, List<EventListener>> listeners;
    private Set<EventListener> robots;
    
    private MainCenterImpl() {
        listeners = new HashMap<>();
        robots = new HashSet<>();
    }
    
    public static MainCenterImpl getInstance() {
        
        if (instance == null) {
            instance = new MainCenterImpl();
        }
        
        return instance;
    }
    
    @Override
    public <E extends Event> void register(E event, EventListener robot) {
        robots.add(robot);
        listeners.computeIfAbsent(event, e -> new ArrayList<>()).add(robot);
    }

    public void unregister(EventListener robot) {
        robots.remove(robot);
        
        for (List<EventListener> values : listeners.values()) {
            values.remove(robot);
        }
    }
    
    @Override
    public <E extends Event> void publish(E event) {
        List<EventListener> interested = listeners.getOrDefault(event, Collections.emptyList());
        
        for (EventListener listener : interested) {
            listener.actualize(event);
        }
    }

    @Override
    public Set<? extends Event> getActions() {
        return listeners.keySet();
    }

    @Override
    public <E extends Event> void initAction(E event) {
        publish(event);
    }

    @Override
    public List<EventListener> getSubject() {
        return List.copyOf(robots);
    }

    @Override
    public void add(EventListener robot) {}

    @Override
    public void remove(EventListener robot) {
        unregister(robot);
    }
    
}
