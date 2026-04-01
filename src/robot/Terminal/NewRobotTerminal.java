package Terminal;

import robot.Robot;
import robot.builder.Director;
import observer_main_center.MainCenter;
import observer_main_center.MainCenterImpl;

import java.util.Map;
import java.util.Scanner;

public class NewRobotTerminal {

    private Director director;
    private Map<String, Robot> robots;
    private Scanner scanner;
    private MainCenter mainCenter;

    public NewRobotTerminal(Map<String, Robot> robots) {
        this.director = new Director();
        this.robots = robots;
        this.scanner = new Scanner(System.in);
        this.mainCenter = MainCenterImpl.getInstance();
    }

    public void start() {
        System.out.println("========================================");
        System.out.println("    DOMOTIC SYSTEM - ROBOT MANAGER");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            showMainMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> createRobot();
                case "0" -> {
                    running = false;
                    System.out.println("Leaving Creation of Robots\n");
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }
        scanner.close();
    }

    private void showMainMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Create new robot");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    private void createRobot() {
        System.out.println("\n--- CREATE NEW ROBOT ---");
        System.out.println("Available robot types:");
        System.out.println("1. Smart washing machine");
        System.out.println("2. Smart dishwasher");
        System.out.println("3. Smart oven");
        System.out.println("4. Vigilant oven");
        System.out.println("5. Plugged sensor");
        System.out.println("6. Smart sensor");
        System.out.println("7. Smart cleaner");
        System.out.println("8. Vigilant cleaner");
        System.out.print("Select type: ");

        String type = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        Robot robot = null;

        switch (type) {
            case "1" -> {
                robot = director.buildSmartWashingMachine(model, id);
                System.out.println("Washing machine created successfully");
            }
            case "2" -> {
                robot = director.buildSmartDishwasher(model, id);
                System.out.println("Dishwasher created successfully");
            }
            case "3" -> {
                robot = director.buildSmartOven(model, id);
                System.out.println("Oven created successfully");
            }
            case "4" -> {
                robot = director.buildSmartVigilantOven(model, id);
                System.out.println("Vigilant oven created successfully");
            }
            case "5" -> {
                robot = director.buildPluggedSensor(model, id);
                System.out.println("Plugged sensor created successfully");
            }
            case "6" -> {
                robot = director.buildSmartSensor(model, id);
                System.out.println("Smart sensor created successfully");
            }
            case "7" -> {
                robot = director.buildSmartCleaner(model, id);
                System.out.println("Smart cleaner created successfully");
            }
            case "8" -> {
                robot = director.buildSmartVigilantCleaner(model, id);
                System.out.println("Vigilant cleaner created successfully");
            }
            default -> {
                System.out.println("Invalid type");
                return;
            }
        }

        if (robot != null) {
            robots.put(id, robot);
            System.out.println("Robot added to system. ID: " + id);
        }
    }
}
