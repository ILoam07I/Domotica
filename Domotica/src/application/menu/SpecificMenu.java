
package application.menu;

import application.mediator.RobotSelector;
import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.Actionable;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class SpecificMenu implements Menu {
    
    private UIProvider ui;
    private Actionable model;
    private EventListener specificModel;

    public SpecificMenu(UIProvider ui, Actionable model, EventListener specificModel) {
        this.ui = ui;
        this.model = model;
        this.specificModel = specificModel;
    }

    @Override
    public void run() {
        String command;
        boolean exit = false;
        
        while (!exit) {
            Set<? extends Event> events = specificModel.getActions();
            
            ui.showMessage("\n\n--- MENU DE EVENTOS ESPECIFICOS PARA " + specificModel.toString() + " ---");
            
            command = ui.showSpecificEventsMenu(events);
            
            switch (command) {               
                case "remove":
                    model.remove(specificModel);
                    
                    break;
                
                case "back":
                    exit = true;
                    break;
                
                default:
                    boolean found = false;
                    
                    for (Event event : events) {
                        if (command.equals(event.getEventInitializer())) {
                            specificModel.initAction(event);
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
