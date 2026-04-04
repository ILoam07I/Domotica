
package application.mediator;

import java.util.Iterator;
import java.util.List;
import observer_main_center.event.event_listener.Actionable;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class RobotSelector {
    
    private UIProvider ui;
    private Actionable model;

    public RobotSelector(UIProvider ui, Actionable model) {
        this.ui = ui;
        this.model = model;
    }

    public EventListener run() {
        List<EventListener> robots = model.getSubject();
        
        ui.showMessage("\n\n--- SELECCIONE UN ROBOT REGISTRADO ---");

        String id = ui.showRobotSelectionMenu(robots);

        Iterator<EventListener> it = robots.iterator();
        boolean found = false;
        EventListener actionable = null;
        
        while(it.hasNext() && !found) {
            actionable = it.next();
            
            if (actionable.getRobot().getId().equals(id)) {
                found = true;
            }
        }

        if (!found) {
            ui.showMessage("ID no encontrado.");
            actionable = null;
        }
        
        return actionable;
    }
    
}
