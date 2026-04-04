package ui;

import java.util.Scanner;

public class UIProvider {
    
    private Scanner scanner;

    public UIProvider() {
        // Inicializamos el lector de teclado una sola vez
        this.scanner = new Scanner(System.in);
    }

    // ==========================================
    // 1. MENÚ PRINCIPAL
    // ==========================================
    public String provideInitialMenu() {
        System.out.println("\n=======================================");
        System.out.println("      SISTEMA DOMÓTICO PRINCIPAL       ");
        System.out.println("=======================================");
        System.out.println("1- Panel de Eventos Globales de la Casa");
        System.out.println("2- Seleccionar y Controlar un Robot");
        System.out.println("3- Apagar el Sistema");
        System.out.println("---------------------------------------");
        System.out.print("Elige una opción (1-3): ");
        
        // Leemos la línea y le hacemos un trim() por si el usuario mete espacios por error
        return scanner.nextLine().trim(); 
    }

    // ==========================================
    // 2. INPUT PARA EL MENÚ DE CREACIÓN
    // ==========================================
    public String provideRobotCreationOption() {
        // Como el Mediator ya imprime la lista de PROTS, la UI solo lee la respuesta
        System.out.print("\nEscribe el nombre del tipo de robot a crear (o 'back' para cancelar): ");
        return scanner.nextLine().trim();
    }

    // ==========================================
    // 3. MÉTODOS DE LECTURA DE DATOS
    // ==========================================
    
    public String provideRobotID() {
        System.out.print("-> Asigna un ID único para el robot (ej. 'robot_01'): ");
        return scanner.nextLine().trim();
    }

    public String provideRobotModel() {
        System.out.print("-> Asigna un Modelo o Nombre para el robot (ej. 'Wall-E'): ");
        return scanner.nextLine().trim();
    }

    // ==========================================
    // 4. MÉTODOS DE COMANDOS Y SELECCIÓN
    // ==========================================
    
    public String provideRobotSelectionMenu() {
        // El Mediator ya imprimió los robots disponibles, aquí solo atrapamos el ID
        System.out.print("\nEscribe el ID del robot que quieres seleccionar: ");
        return scanner.nextLine().trim();
    }

    public String provideCommandMenu() {
        // Sirve tanto para los eventos globales como específicos (lee 'add', 'remove', 'back' o el comando)
        System.out.print("\nEscribe el comando que deseas ejecutar: ");
        return scanner.nextLine().trim();
    }
}