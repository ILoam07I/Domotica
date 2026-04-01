package Terminal;

import robot.Robot;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Terminal {
    
    private static Map<String, Robot> robots = new HashMap<>();
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       DOMOTIC SYSTEM");
        System.out.println("========================================");
        
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        
        while (running) {
            System.out.println("\n--- MAIN SYSTEM MENU ---");
            System.out.println("1. Robot Creation");
            System.out.println("2. Room Management");
            System.out.println("0. Exit");
            System.out.print("Select module: ");
            
            String option = scanner.nextLine();
            
            switch (option) {
                case "1" -> {
                    NewRobotTerminal robotTerminal = new NewRobotTerminal(robots);
                    robotTerminal.start();
                }
                case "2" -> {
                    NewRoomTerminal roomTerminal = new NewRoomTerminal(robots);
                    roomTerminal.start();
                }
                case "0" -> {
                    running = false;
                    System.out.println("System Shutdown");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        
        scanner.close();
    }
}