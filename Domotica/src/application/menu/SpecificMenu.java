
package application.menu;

import java.util.Set;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class SpecificMenu implements Menu {
    
    private UIProvider ui;
    private MainCenterImpl model;
    private EventListener specificModel;

    public SpecificMenu(UIProvider ui, MainCenterImpl model, EventListener specificModel) {
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
            
            ui.showMessage("\n\n--- MENU DE EVENTOS ESPECIFICOS  ---");
            
            command = ui.showSpecificEventsMenu(events);
            
            switch (command) {               
                case "remove":
                    ui.showMessage("\n--> Borrando robot.");
                    
                    if (model.unregister(specificModel)) {                    
                        ui.showMessage("\n... Robot borrado correctamente.");
                        
                    } else {
                        ui.showMessage("\n... Error en el borrado.");
                    }
                    
                    ui.showConfirmation();
                    
                    exit = true;
                    
                    break;
                
                case "back":
                    exit = true;
                    break;
                
                default:
                    boolean found = false;
                    
                    for (Event event : events) {
                        if (command.equals(event.getEventInitializer())) {
                            specificModel.actualize(event);
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
