
package application.menu;

import application.mediator.RobotSelector;
import java.util.Set;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class GlobalMenu implements Menu {
    
    private UIProvider ui;
    private MainCenterImpl model;
    private RobotSelector selector;

    public GlobalMenu(UIProvider ui, MainCenterImpl model, RobotSelector selector) {
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
                    CreateRobotMenu creationalMenu = new CreateRobotMenu(ui);
                    creationalMenu.run();
                    break;
                
                case "remove":
                    EventListener selected = selector.run();
                    
                    if (selected != null) {
                        ui.showMessage("\n--> Borrando robot.");
                        
                        if (model.unregister(selected)) {                        
                            ui.showMessage("\n... Robot borrado correctamente.");
                            
                        } else {
                            ui.showMessage("\n...Error en el borrado.");
                        }
                        
                        ui.showConfirmation();
                    }
                    
                    break;
                
                case "back":
                    exit = true;
                    break;
                
                default:
                    boolean found = false;
                    
                    for (Event event : events) {
                        if (command.equals(event.getEventInitializer())) {
                            model.publish(event);
                            found = true;
                            
                            ui.showConfirmation();
                            
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
