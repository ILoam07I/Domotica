
package ui;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import observer_main_center.event.Event;
import observer_main_center.event.event_listener.EventListener;

public class UIProvider {
    
    private Scanner scanner;

    public UIProvider() {
        this.scanner = new Scanner(System.in);
    }
    
    public String provideInitialMenu() {
        scanner.reset();
        
        System.out.println("\n\n=== PANEL DE CONTROL DOMOTICO ===");
        System.out.println("1- Lanzar Evento Global (A toda la casa)");
        System.out.println("2- Controlar Robot Especifico");
        System.out.println("3- Salir");
        System.out.print("Seleccione una opcion: ");
        
        return scanner.nextLine();
    }
    
    public String showGlobalEventsMenu(Set<? extends Event> events) {
        scanner.reset();
        int option = 1;
        
        for (Event event: events) {
            System.out.println(option + "- " + event.getEventDescription());
            option++;
        }
        System.out.println(option + "- [add] Registrar nuevo robot.");
        option++;
        
        System.out.println(option + "- [remove] Eliminar robot registrado.");
        option++;
        
        System.out.println(option + "- [back] Cancelar.");
        
        System.out.print("Seleccione un comando disponible: ");
        
        return scanner.nextLine();
    }
    
    public String showSpecificEventsMenu(Set<? extends Event> events) {
        scanner.reset();
        int option = 1;
        
        for (Event event: events) {
            System.out.println(option + "- " + event.getEventDescription());
            option++;
        }
        
        System.out.println(option + "- [remove] Eliminar robot registrado.");
        option++;
        
        System.out.println(option + "- [back] Cancelar.");
        
        System.out.print("Seleccione un comando disponible: ");
        
        return scanner.nextLine();
    }
    
    public String showRobotSelectionMenu(List<EventListener> robots) {
        scanner.reset();
        int option = 1;
        
        for (EventListener robot : robots) {
            System.out.println(robot.getRobot().describe());
        }
        
        System.out.println("Seleccione una id disponible: ");
        
        return scanner.nextLine();
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
    
    public void showInvalidOption() {
        System.out.println("Opcion invalida.");
    }
    
    public String provideCommandMenu() {   
        scanner.reset();
        
        System.out.print("Seleccione un comando: ");
        
        return scanner.nextLine();
    }
    
    public String provideRobotSelectionMenu() {
        scanner.reset();
        
        System.out.print("Seleccione un robot por su id: ");
        
        return scanner.nextLine();
    }
    
    public String provideRobotCreationOption() {
        scanner.reset();
        
        System.out.print("Seleccione una opcion de creacion: ");
        
        return scanner.nextLine();
    }
    
    public String provideRobotID() {
        scanner.reset();
        
        System.out.print("Introduzca la id del nuevo robot: ");
        
        return scanner.nextLine();
    }
    
    public String provideRobotModel() {
        scanner.reset();
        
        System.out.print("Introduzca el modelo del nuevo robot: ");
        
        return scanner.nextLine();
    }
    
}
