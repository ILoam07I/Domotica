package application.mediator;

import application.menu.GlobalMenu;
import application.menu.Menu;
import application.menu.SpecificMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import observer_main_center.MainCenter;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.Actionable;
import observer_main_center.event.event_listener.EventListener;
import robot.builder.Director;
import robot.builder.RobotBuilder;
import ui.UIProvider;

public class UIApplicationMediator {
    
    public static final List<String> PROTS = List.of(
            "smart_oven",
            "smart_vigilant_oven",
            "smart_washing_machine",
            "plugged_sensor",
            "smart_sensor",
            "smart_vigilant_cleaner");
    
    private UIProvider ui;
    private Actionable model;
    private RobotSelector selector;

    public UIApplicationMediator() {
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
                    mediateSpecificMenu(selector.run());
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
    
    public void mediateCreateRobotMenu() {
        boolean exit = false;
        int option;
        String command;
        
        while (!exit) {
            option = 1;
            
            System.out.println("\n\n--- PANEL DE CREACION DE ROBOTS ---");
            for (String key : Director.PROTS.keySet()) {
                System.out.println(option + "- [" + key + "]");
                option++;
            }
            System.out.println(option + "- [back] Cancelar.");
            
            command = ui.provideRobotCreationOption();
            
            switch (command) {
                case "back":
                    exit = true;
                    break;
                
                default:
                    if (!Director.PROTS.containsKey(command)) {
                        System.out.println("Opcion no valida.");
                
                    } else {

                        Supplier<RobotBuilder> supplier = Director.PROTS.get(command);
                        RobotBuilder builderInstance = supplier.get();

                        Director director = new Director(builderInstance);

                        String robotId = ui.provideRobotID();
                        String robotModel = ui.provideRobotModel();

                        director.buildRobot(robotModel, robotId);

                        System.out.println("Robot registrado correctamente.");
                        exit = true;
                    }
            }
        }
    }
    
    public void mediateRemoveRobotMenu(EventListener robot) {
        MainCenter modelCenter = MainCenterImpl.getInstance();
        
        modelCenter.unregister(robot);
        System.out.println("Robot eliminado correctamente.");
    }
    
}