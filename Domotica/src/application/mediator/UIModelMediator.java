package application.mediator;

import application.menu.GlobalMenu;
import application.menu.Menu;
import application.menu.SpecificMenu;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.event_listener.EventListener;
import ui.UIProvider;

public class UIModelMediator {
    
    private UIProvider ui;
    private MainCenterImpl model;
    private RobotSelector selector;

    public UIModelMediator() {
        ui = new UIProvider();
        model = MainCenterImpl.getInstance();
        selector = new RobotSelector(ui, model);
    }
    
    public void mediateInitialMenu() {
        boolean exit = false;
        String option;
        
        while (!exit) {
            option = ui.provideInitialMenu();

            switch (option) {
                case "1":
                    mediateGlobalMenu();
                    break;

                case "2":
                    EventListener selected = selector.run();
                    
                    if (selected != null) {
                        mediateSpecificMenu(selected);
                    }
                    break;

                case "3":
                    exit = true;
                    System.out.println("Apagando sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
    
    public void mediateGlobalMenu() {
        Menu globalMenu = new GlobalMenu(ui, model, selector);
        
        globalMenu.run();
    }
    
    public void mediateSpecificMenu(EventListener specificModel) {        
        Menu specificMenu = new SpecificMenu(ui, model, specificModel);
        
        specificMenu.run();
    }
    
}