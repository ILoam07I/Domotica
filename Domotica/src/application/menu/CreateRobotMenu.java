
package application.menu;

import ui.UIProvider;

public class CreateRobotMenu implements Menu {
    
    private UIProvider ui;

    public CreateRobotMenu(UIProvider ui) {
        this.ui = ui;
    }

    @Override
    public void run() {
        String command;
        boolean exit = false;
        
        while(!exit) {
            ui.showMessage("\n\n--- MENU DE CREACION DE ROBOT ---");
            
        }
    }
    
}
