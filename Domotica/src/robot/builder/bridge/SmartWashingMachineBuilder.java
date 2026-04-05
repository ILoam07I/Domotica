
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.EcoModeEvent;
import observer_main_center.event.Event;
import observer_main_center.event.InitLaundryEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import observer_main_center.event.StopLaundryEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.PowerDecorator;
import robot.decorator.WashingMachineDecorator;

public class SmartWashingMachineBuilder extends AbsRobotBuilderImpl {

    @Override
    public List<? extends Event> getEvents() {
        return List.of(
                new NightModeEvent(),
                new EcoModeEvent(),
                new NormalModeEvent(),
                new PowerOnEvent(),
                new PowerOffEvent(),
                new InitLaundryEvent(),
                new StopLaundryEvent());
    }

    @Override
    public void addDecorator() {
        WashingMachineDecorator washingMachineModule = new WashingMachineDecorator(robot);
        robot = washingMachineModule;
        PowerDecorator powerModule = new PowerDecorator(robot);
        robot = powerModule;
        
        robot.addModule(washingMachineModule);
        robot.addModule(powerModule);
    }
   
}
