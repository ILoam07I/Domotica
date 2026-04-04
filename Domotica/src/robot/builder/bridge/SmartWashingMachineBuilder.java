
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.EcoModeEvent;
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
    public void setEvents() {
        robot.setEvents(List.of(
                new NightModeEvent(),
                new EcoModeEvent(),
                new NormalModeEvent(),
                new PowerOnEvent(),
                new PowerOffEvent(),
                new InitLaundryEvent(),
                new StopLaundryEvent()));
    }

    @Override
    public void addDecorator() {
        robot = new WashingMachineDecorator(robot);
        robot = new PowerDecorator(robot);
    }
   
}
