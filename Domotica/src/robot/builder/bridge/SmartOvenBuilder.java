
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.EcoModeEvent;
import observer_main_center.event.InitHeatEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import observer_main_center.event.StopHeatEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.OvenDecorator;
import robot.decorator.PowerDecorator;

public class SmartOvenBuilder extends AbsRobotBuilderImpl {

    @Override
    public void setEvents() {
        robot.setEvents(List.of(
                new NightModeEvent(),
                new EcoModeEvent(),
                new NormalModeEvent(),
                new PowerOnEvent(),
                new PowerOffEvent(),
                new InitHeatEvent(),
                new StopHeatEvent()));
    }

    @Override
    public void addDecorator() {
        OvenDecorator ovenModule = new OvenDecorator(robot);
        robot = ovenModule;
        PowerDecorator powerModule = new PowerDecorator(robot);
        robot = powerModule;
        
        robot.addModule(ovenModule);
        robot.addModule(powerModule);
    }
    
}
