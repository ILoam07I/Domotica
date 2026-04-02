import java.util.Scanner;
import java.util.List;
import facade.SubscriberFacade;
// Importamos tus eventos reales
import observer_main_center.event.*; 

public class GlobalInterface {

    private SubscriberFacade fachada;
    private Scanner scanner;

    public GlobalInterface() {
        this.fachada = new SubscriberFacade();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== PANEL DE CONTROL DOMÓTICO ===");
            System.out.println("1. Lanzar Evento Global (A toda la casa)");
            System.out.println("2. Controlar Robot Específico");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    menuEventosGlobales();
                    break;
                case "2":
                    menuRobotsEspecificos();
                    break;
                case "3":
                    salir = true;
                    System.out.println("Apagando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // --- SUBMENÚ 1: EVENTOS GLOBALES ---
    private void menuEventosGlobales() {
        System.out.println("\n--- EVENTOS GLOBALES ---");
        System.out.println("1. Activar Modo Noche");
        System.out.println("2. Activar Modo Eco");
        System.out.println("3. Activar Modo Normal");
        System.out.println("4. Iniciar hornos");
        System.out.println("5. Parar hornos");
        System.out.println("6. Iniciar lavadoras");
        System.out.println("7. Parar lavadoras");
        System.out.println("8. Iniciar modo vigilancia");
        System.out.println("9. Iniciar modo descanso (Rest)");
        System.out.println("10. Apagar todo");
        System.out.println("11. Encender todo");
        System.out.println("12. Volver al menú principal");
        System.out.print("Elija el evento a emitir: ");

        String opcion = scanner.nextLine();
        
        switch (opcion) {
            case "1":
                fachada.publicarEventoGlobal(new NightModeEvent());
                System.out.println("-> Evento 'Modo Noche' publicado a toda la casa.");
                break;
            case "2":
                fachada.publicarEventoGlobal(new EcoModeEvent());
                System.out.println("-> Evento 'Modo Eco' publicado a toda la casa.");
                break;
            case "3":
                fachada.publicarEventoGlobal(new NormalModeEvent());
                System.out.println("-> Evento 'Modo Normal' publicado.");
                break;
            case "4":
                fachada.publicarEventoGlobal(new InitHeatEvent());
                System.out.println("-> Evento 'Iniciar Hornos' publicado.");
                break;
            case "5":
                fachada.publicarEventoGlobal(new StopHeatEvent());
                System.out.println("-> Evento 'Parar Hornos' publicado.");
                break;
            case "6":
                fachada.publicarEventoGlobal(new InitLaundryEvent());
                System.out.println("-> Evento 'Iniciar Lavadoras' publicado.");
                break;
            case "7":
                fachada.publicarEventoGlobal(new StopLaundryEvent());
                System.out.println("-> Evento 'Parar Lavadoras' publicado.");
                break;
            case "8":
                fachada.publicarEventoGlobal(new InitVigilanceEvent());
                System.out.println("-> Evento 'Modo Vigilancia' publicado.");
                break;
            case "9":
                fachada.publicarEventoGlobal(new InitRestEvent());
                System.out.println("-> Evento 'Modo Descanso' publicado.");
                break;
            case "10":
                fachada.publicarEventoGlobal(new PowerOffEvent());
                System.out.println("-> Evento 'Apagar Todo' publicado.");
                break;
            case "11":
                fachada.publicarEventoGlobal(new PowerOnEvent());
                System.out.println("-> Evento 'Encender Todo' publicado.");
                break;
            case "12":
                return; 
            default:
                System.out.println("Opción inválida.");
        }
    }

    // --- SUBMENÚ 2: ROBOT ESPECÍFICO ---
    private void menuRobotsEspecificos() {
        List<String> nombresRobots = fachada.obtenerNombresRobotsInstalados();
        
        if (nombresRobots.isEmpty()) {
            System.out.println("No hay robots instalados en la casa.");
            return;
        }

        System.out.println("\n--- ROBOTS INSTALADOS ---");
        for (int i = 0; i < nombresRobots.size(); i++) {
            System.out.println((i + 1) + ". " + nombresRobots.get(i));
        }
        System.out.print("Seleccione el número del robot: ");
        
        try {
            int indexRobot = Integer.parseInt(scanner.nextLine()) - 1;
            String nombreRobotElegido = nombresRobots.get(indexRobot);
            
            List<String> eventosDisponibles = fachada.obtenerEventosDeRobot(indexRobot);
            
            System.out.println("\n--- EVENTOS/COMANDOS PARA " + nombreRobotElegido + " ---");
            for (int i = 0; i < eventosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + eventosDisponibles.get(i));
            }
            System.out.print("Seleccione qué aplicarle: ");
            
            int indexEvento = Integer.parseInt(scanner.nextLine()) - 1;
            String eventoElegido = eventosDisponibles.get(indexEvento);
            
            fachada.ejecutarEventoEnRobot(nombreRobotElegido, eventoElegido);
            System.out.println("-> Acción '" + eventoElegido + "' enviada a " + nombreRobotElegido);

        } catch (Exception e) {
            System.out.println("Entrada inválida o error al procesar.");
        }
    }
}