package Terminal;

import robot.Robot;
import java.util.*;

public class NewRoomTerminal {

    private Map<String, Room> rooms;
    private Map<String, Robot> availableRobots;
    private Scanner scanner;

    public NewRoomTerminal(Map<String, Robot> robots) {
        this.rooms = new HashMap<>();
        this.availableRobots = robots;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("========================================");
        System.out.println("       ROOM MANAGEMENT SYSTEM");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            showMainMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "1" ->
                    createRoom();
                case "2" ->
                    listRooms();
                case "3" ->
                    viewRoomDetails();
                case "4" ->
                    addRobotToRoom();
                case "5" ->
                    removeRobotFromRoom();
                case "6" ->
                    listRobotsInRoom();
                case "7" ->
                    executeRoomAction();
                case "0" -> {
                    running = false;
                    System.out.println("\nExiting room management system. Goodbye!");
                }
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n--- ROOM MANAGEMENT MENU ---");
        System.out.println("1. Create new room");
        System.out.println("2. List all rooms");
        System.out.println("3. View room details");
        System.out.println("4. Add robot to room");
        System.out.println("5. Remove robot from room");
        System.out.println("6. List robots in room");
        System.out.println("7. Execute room action");
        System.out.println("0. Exit to main menu");
        System.out.print("Select an option: ");
    }

    private void createRoom() {
        System.out.println("\n--- CREATE NEW ROOM ---");
        System.out.print("Enter room name: ");
        String name = scanner.nextLine();
        System.out.print("Enter room ID: ");
        String id = scanner.nextLine();

        // Validate if room already exists
        if (rooms.containsKey(id)) {
            System.out.println("A room with this ID already exists.");
            return;
        }

        System.out.println("\nRoom types available:");
        System.out.println("1. Living Room");
        System.out.println("2. Kitchen");
        System.out.println("3. Bedroom");
        System.out.println("4. Bathroom");
        System.out.println("5. Office");
        System.out.println("6. Garage");
        System.out.println("7. Garden");
        System.out.println("8. Custom");
        System.out.print("Select room type: ");

        String typeOption = scanner.nextLine();
        String roomType = getRoomType(typeOption);

        if (roomType.equals("Custom")) {
            System.out.print("Enter custom room type: ");
            roomType = scanner.nextLine();
        }

        System.out.print("Enter room dimensions (optional, e.g., 5x4 meters): ");
        String dimensions = scanner.nextLine();

        Room room = new Room(id, name, roomType, dimensions);
        rooms.put(id, room);

        System.out.println("Room created successfully!");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + roomType);
    }

    private String getRoomType(String option) {
        return switch (option) {
            case "1" ->
                "Living Room";
            case "2" ->
                "Kitchen";
            case "3" ->
                "Bedroom";
            case "4" ->
                "Bathroom";
            case "5" ->
                "Office";
            case "6" ->
                "Garage";
            case "7" ->
                "Garden";
            default ->
                "Custom";
        };
    }

    private void listRooms() {
        System.out.println("\n--- ALL ROOMS ---");
        if (rooms.isEmpty()) {
            System.out.println("No rooms created yet.");
            return;
        }

        for (Room room : rooms.values()) {
            System.out.printf("ID: %-10s | Name: %-15s | Type: %-15s | Robots: %d%n",
                    room.getId(),
                    room.getName(),
                    room.getType(),
                    room.getRobotCount());
        }
    }

    private void viewRoomDetails() {
        System.out.println("\n--- VIEW ROOM DETAILS ---");
        System.out.print("Enter room ID: ");
        String id = scanner.nextLine();

        Room room = rooms.get(id);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.println("\n=== ROOM DETAILS ===");
        System.out.println("ID: " + room.getId());
        System.out.println("Name: " + room.getName());
        System.out.println("Type: " + room.getType());
        System.out.println("Dimensions: " + (room.getDimensions().isEmpty() ? "Not specified" : room.getDimensions()));
        System.out.println("Number of robots: " + room.getRobotCount());

        if (room.getRobotCount() > 0) {
            System.out.println("\nRobots in this room:");
            for (String robotId : room.getRobotIds()) {
                Robot robot = availableRobots.get(robotId);
                if (robot != null) {
                    System.out.printf("  - %s (%s)%n", robotId, robot.getModelName());
                } else {
                    System.out.printf("  - %s (Robot data not available)%n", robotId);
                }
            }
        }
    }

    private void addRobotToRoom() {
        System.out.println("\n--- ADD ROBOT TO ROOM ---");

        if (availableRobots.isEmpty()) {
            System.out.println("No robots available. Please create robots first.");
            return;
        }

        if (rooms.isEmpty()) {
            System.out.println("No rooms available. Please create a room first.");
            return;
        }

        System.out.println("Available rooms:");
        for (Room room : rooms.values()) {
            System.out.printf("  - %s (%s)%n", room.getId(), room.getName());
        }

        System.out.print("\nEnter room ID: ");
        String roomId = scanner.nextLine();

        Room room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.println("\nAvailable robots:");
        for (Map.Entry<String, Robot> entry : availableRobots.entrySet()) {
            System.out.printf("  - %s (%s)%n", entry.getKey(), entry.getValue().getModelName());
        }

        System.out.print("\nEnter robot ID to add: ");
        String robotId = scanner.nextLine();

        Robot robot = availableRobots.get(robotId);
        if (robot == null) {
            System.out.println("Robot not found.");
            return;
        }

        if (room.addRobot(robotId)) {
            System.out.printf("Robot %s added to room %s successfully!%n", robotId, room.getName());
        } else {
            System.out.printf("Robot %s is already in room %s.%n", robotId, room.getName());
        }
    }

    private void removeRobotFromRoom() {
        System.out.println("\n--- REMOVE ROBOT FROM ROOM ---");

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.print("Enter room ID: ");
        String roomId = scanner.nextLine();

        Room room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (room.getRobotCount() == 0) {
            System.out.println("This room has no robots to remove.");
            return;
        }

        System.out.println("\nRobots in this room:");
        for (String robotId : room.getRobotIds()) {
            Robot robot = availableRobots.get(robotId);
            if (robot != null) {
                System.out.printf("  - %s (%s)%n", robotId, robot.getModelName());
            }
        }

        System.out.print("\nEnter robot ID to remove: ");
        String robotId = scanner.nextLine();

        if (room.removeRobot(robotId)) {
            System.out.printf("Robot %s removed from room %s successfully!%n", robotId, room.getName());
        } else {
            System.out.printf("Robot %s not found in room %s.%n", robotId, room.getName());
        }
    }

    private void listRobotsInRoom() {
        System.out.println("\n--- LIST ROBOTS IN ROOM ---");

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.print("Enter room ID: ");
        String roomId = scanner.nextLine();

        Room room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.println("\n=== ROBOTS IN " + room.getName().toUpperCase() + " ===");

        List<String> robotIds = room.getRobotIds();
        if (robotIds.isEmpty()) {
            System.out.println("No robots in this room.");
            return;
        }

        for (int i = 0; i < robotIds.size(); i++) {
            String robotId = robotIds.get(i);
            Robot robot = availableRobots.get(robotId);
            if (robot != null) {
                System.out.printf("%d. ID: %-10s | Model: %-15s | Type: %s%n",
                        i + 1,
                        robotId,
                        robot.getModelName(),
                        robot.getClass().getSimpleName());
            } else {
                System.out.printf("%d. ID: %-10s | (Robot data not available)%n", i + 1, robotId);
            }
        }
    }

    private void executeRoomAction() {
        System.out.println("\n--- EXECUTE ROOM ACTION ---");

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.print("Enter room ID: ");
        String roomId = scanner.nextLine();

        Room room = rooms.get(roomId);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.println("\nAvailable actions:");
        System.out.println("1. Broadcast event to all robots in room");
        System.out.println("2. Check room status");
        System.out.print("Select action: ");

        String action = scanner.nextLine();

        switch (action) {
            case "1" ->
                broadcastEventToRoom(room);
            case "2" ->
                checkRoomStatus(room);
            default ->
                System.out.println("Invalid action.");
        }
    }

    private void broadcastEventToRoom(Room room) {
        System.out.println("\n--- BROADCAST EVENT ---");
        System.out.println("Event types:");
        System.out.println("1. Home alone event");
        System.out.println("2. Home guarded event");
        System.out.print("Select event type: ");

        String eventType = scanner.nextLine();

        if (!(eventType.equals("1") || eventType.equals("2"))) {
            System.out.println("Unknown event");
            System.out.println("Broadcast canceled");
        } else {
            System.out.println("\nBroadcasting to " + room.getRobotCount() + " robots in " + room.getName() + "...");

            for (String robotId : room.getRobotIds()) {
                Robot robot = availableRobots.get(robotId);
                if (robot != null) {
                    if (eventType.equals("1")) {
                        robot.performAction(new observer_main_center.event.HomeAloneEvent(robot));
                        System.out.printf("Event sent to %s%n", robotId);
                    } else if (eventType.equals("2")) {
                        robot.performAction(new observer_main_center.event.HomeGuardedEvent(robot));
                        System.out.printf("Event sent to %s%n", robotId);
                    }
                }
            }
            System.out.println("Broadcast completed!");
        }
    }

    private void checkRoomStatus(Room room) {
        System.out.println("\n--- ROOM STATUS ---");
        System.out.println("Room: " + room.getName());
        System.out.println("Type: " + room.getType());
        System.out.println("Robots: " + room.getRobotCount() + " connected");

        if (room.getRobotCount() > 0) {
            int activeRobots = 0;
            for (String robotId : room.getRobotIds()) {
                Robot robot = availableRobots.get(robotId);
                if (robot != null) {
                    // Check if robot has power module and is powered
                    if (robot instanceof robot.decorator.AbsRobotDecoratorImpl decorated) {
                        robot.decorator.PowerDecorator power
                                = decorated.getModule(robot.decorator.PowerDecorator.class);
                        if (power != null && power.isPowered()) {
                            activeRobots++;
                        }
                    } else {
                        activeRobots++;
                    }
                }
            }
            System.out.println("Active robots: " + activeRobots);
        }

        System.out.println("Status: " + (room.getRobotCount() > 0 ? "Operational" : "Empty"));
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    // Inner class representing a Room
    public static class Room {

        private String id;
        private String name;
        private String type;
        private String dimensions;
        private List<String> robotIds;

        public Room(String id, String name, String type, String dimensions) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.dimensions = dimensions;
            this.robotIds = new ArrayList<>();
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDimensions() {
            return dimensions;
        }

        public List<String> getRobotIds() {
            return new ArrayList<>(robotIds);
        }

        public int getRobotCount() {
            return robotIds.size();
        }

        public boolean addRobot(String robotId) {
            if (!robotIds.contains(robotId)) {
                return robotIds.add(robotId);
            }
            return false;
        }

        public boolean removeRobot(String robotId) {
            return robotIds.remove(robotId);
        }

        public boolean hasRobot(String robotId) {
            return robotIds.contains(robotId);
        }

        @Override
        public String toString() {
            return String.format("Room{id='%s', name='%s', type='%s', robots=%d}",
                    id, name, type, robotIds.size());
        }
    }
}
