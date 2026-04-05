
package application;

import application.mediator.UIModelMediator;
import robot.builder.Director;
import robot.builder.bridge.PluggedSensorBuilder;
import robot.builder.bridge.SmartOvenBuilder;
import robot.builder.bridge.SmartSensorBuilder;
import robot.builder.bridge.SmartVigilantCleanerBuilder;
import robot.builder.bridge.SmartVigilantOvenBuilder;
import robot.builder.bridge.SmartWashingMachineBuilder;

public class Application {

    public static void main(String[] args) {
        UIModelMediator uiMediator = new UIModelMediator();
        
        test();
        
        uiMediator.mediateInitialMenu();        
    }
    
    public static void test() {
        //Test de prueba para crear y registrar algunos robots (se puede quitar):
        Director dir = new Director(PluggedSensorBuilder::new);
        dir.buildRobot("Prueba1: Sensor", "PS1");
        
        dir = new Director(SmartSensorBuilder::new);
        dir.buildRobot("Prueba2: Sensor Inteligente", "SS1");
        
        dir = new Director(SmartOvenBuilder::new);
        dir.buildRobot("Prueba3: Horno Inteligente", "SO1");
        
        dir = new Director(SmartVigilantOvenBuilder::new);
        dir.buildRobot("Prueba4: Horno Inteligente con Camara", "SVO1");
        
        dir = new Director(SmartWashingMachineBuilder::new);
        dir.buildRobot("Prueba5: Lavadora Inteligente", "SWM1");
        
        dir = new Director(SmartVigilantCleanerBuilder::new);
        dir.buildRobot("Prueba6: Robot Limpiador con Camara", "SVC1");
    }
    
}
