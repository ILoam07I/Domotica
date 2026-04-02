package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer_main_center.MainCenter;
import observer_main_center.MainCenterImpl;
import observer_main_center.event.Event;
import robot.Robot;
import robot.adapter.RobotAdapter;

public class SubscriberFacade {
    
    private MainCenter hub;
    // Mapa para guardar los robots instalados y poder listarlos en el menú 2
    private Map<String, Robot> robotsInstalados;

    public SubscriberFacade() {
        hub = MainCenterImpl.getInstance();
        robotsInstalados = new HashMap<>();
    }
    
    // Método original (Suscripción)
    public void subscribe(Robot robot, List<Class<? extends Event>> types) {
        RobotAdapter robotListener = new RobotAdapter(robot);
        for (Class<? extends Event> type : types) {
            hub.register(type, robotListener);
        }
    }

    // --- NUEVOS MÉTODOS PARA LA INTERFAZ ---

    // 1. Registrar un robot en la fachada
    public void registrarRobot(String nombre, Robot robot) {
        robotsInstalados.put(nombre, robot);
    }

    // 2. Método genérico para publicar cualquier evento global
    public void publicarEventoGlobal(Event event) {
        hub.publish(event);
    }

    // 3. Obtener la lista de nombres para el menú
    public List<String> obtenerNombresRobotsInstalados() {
        return new ArrayList<>(robotsInstalados.keySet());
    }

    // 4. Obtener los eventos/comandos específicos de un robot
    public List<String> obtenerEventosDeRobot(String nombre) {
        Robot robot = robotsInstalados.get(nombre);
        List<String> opciones = new ArrayList<>();
        
        if (robot != null) {
            // NOTA: Aquí deberías llamar a tu método robot.getEvents() real.
            // Pongo estos de ejemplo simulando lo que devolvería.
            opciones.add("Encender (PowerOn)");
            opciones.add("Apagar (PowerOff)");
            opciones.add("Cambiar a Modo Eco");
        }
        return opciones;
    }

    // 5. Ejecutar la orden directa en el robot
    public void ejecutarEventoEnRobot(String nombreRobot, String eventoElegido) {
        Robot robot = robotsInstalados.get(nombreRobot);
        if (robot != null) {
            // NOTA: Aquí iría la lógica para traducir el String a tu patrón Command
            // o pasarlo al process() del robot.
            System.out.println("[Sistema] Ejecutando comando interno en el robot...");
        }
    }
}