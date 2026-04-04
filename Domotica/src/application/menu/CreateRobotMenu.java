
package application.menu;

import java.util.Set;
import java.util.function.Supplier;
import robot.builder.Director;
import robot.builder.RobotBuilder;
import ui.UIProvider;

public class CreateRobotMenu implements Menu {
    
    private UIProvider ui;

    public CreateRobotMenu(UIProvider ui) {
        this.ui = ui;
    }

    @Override
    public void run() {
        String command;
        boolean exit = false;
        
        while(!exit) {
            Set<String> commands = Director.PROTS.keySet();
            
            ui.showMessage("\n\n--- MENU DE CREACION DE ROBOT ---");
            
            command = ui.showCreationalMenu(commands);
            
            switch (command) {
                case "back":
                    exit = true;
                    break;
                
                default:
                    if (commands.contains(command)) {
                        Supplier<RobotBuilder> supplier = Director.PROTS.get(command);
                        
                        RobotBuilder builder = supplier.get();
                        Director director = new Director(builder);

                        String robotId = ui.provideRobotID();
                        String robotModel = ui.provideRobotModel();
                        
                        ui.showMessage("\n--> Registrando robot.");

                        if (director.buildRobot(robotModel, robotId)) {
                            ui.showMessage("\n... Robot registrado correctamente.");
                        
                        } else {
                            ui.showMessage("\n... Error en el registro (id repetida).");
                        }
                        
                        ui.showConfirmation();
                        
                    } else {
                        ui.showInvalidOption();
                        exit = true;
                    }
            }
        }
    }
    
}
