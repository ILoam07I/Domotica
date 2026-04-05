
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.EcoModeEvent;
import observer_main_center.event.Event;
import observer_main_center.event.InitRestEvent;
import observer_main_center.event.InitVigilanceEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.BatteryDecorator;
import robot.decorator.PowerDecorator;
import robot.decorator.VigilanceDecorator;

public class SmartVigilantCleanerBuilder extends AbsRobotBuilderImpl {

    @Override
    public List<? extends Event> getEvents() {
        return List.of(
                new NightModeEvent(),
                new EcoModeEvent(),
                new NormalModeEvent(),
                new PowerOnEvent(),
                new PowerOffEvent(),
                new InitVigilanceEvent(),
                new InitRestEvent());
    }

    @Override
    public void addDecorator() {
        VigilanceDecorator vigilanceModule = new VigilanceDecorator(robot);
        robot = vigilanceModule;
        BatteryDecorator batteryModule = new BatteryDecorator(robot);
        robot = batteryModule;
        PowerDecorator powerModule = new PowerDecorator(robot);
        robot = powerModule;
        
        robot.addModule(vigilanceModule);
        robot.addModule(batteryModule);
        robot.addModule(powerModule);
    }
    
}
