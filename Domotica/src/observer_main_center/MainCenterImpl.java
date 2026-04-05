
package observer_main_center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public class MainCenterImpl implements MainCenter, EventListenerContainer, ActionProvider {
    
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
    public <E extends Event> boolean register(EventListener robot, List<? extends Event> events) {
        boolean added = robots.add(robot);
        
        if (added) {
            for (Event event : events) {
                listeners.computeIfAbsent(event, e -> new ArrayList<>()).add(robot);
            }
        }
        
        return added;
    }

    @Override
    public boolean unregister(EventListener robot) {
        boolean removed = robots.remove(robot);
        
        if (removed) {
            System.out.println(robot.toString());
            robot.getRobot().forceShutOff();

            //Eliminamos la key si queda vacía para quitarla de eventos lanzables.
            Iterator<Map.Entry<Event, List<EventListener>>> it = listeners.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<Event, List<EventListener>> entry = it.next();

                List<EventListener> list = entry.getValue();
                list.remove(robot);

                if (list.isEmpty()) {
                    it.remove();
                }
            }
        }
        
        return removed;
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
    public List<EventListener> getSubject() {
        return List.copyOf(robots);
    }

}
