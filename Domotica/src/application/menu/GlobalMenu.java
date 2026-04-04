
package application.menu;

import application.mediator.RobotSelector;
import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.Actionable;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class GlobalMenu implements Menu {
    
    private UIProvider ui;
    private Actionable model;
    private RobotSelector selector;

    public GlobalMenu(UIProvider ui, Actionable model, RobotSelector selector) {
        this.ui = ui;
        this.model = model;
        this.selector = selector;
    }

    @Override
    public void run() {
        String command;
        boolean exit = false;
        
        while (!exit) {
            Set<? extends Event> events = model.getActions();
            
            ui.showMessage("\n\n--- MENU DE EVENTOS GLOBALES ---");
            
            command = ui.showGlobalEventsMenu(events);
            
            switch (command) {
                case "add":
                    break;
                
                case "remove":
                    EventListener robot = selector.run();
                    
                    if (robot != null) {
                        model.remove(robot);
                    }
                    
                    break;
                
                case "back":
                    exit = true;
                    break;
                
                default:
                    boolean found = false;
                    
                    for (Event event : events) {
                        if (command.equals(event.getEventInitializer())) {
                            model.initAction(event);
                            found = true;
                            
                            break;
                        }
                    }
                    
                    if (!found) {
                        ui.showInvalidOption();
                        exit = true;
                    }
            }
        }      
    }
    
}
