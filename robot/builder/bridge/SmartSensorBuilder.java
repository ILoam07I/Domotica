
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.InitRestEvent;
import observer_main_center.event.InitVigilanceEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.PowerDecorator;
import robot.decorator.VigilanceDecorator;

public class SmartSensorBuilder extends AbsRobotBuilderImpl {

    @Override
    public void setEvents() {
        robot.setEvents(List.of(new NightModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitVigilanceEvent(), new InitRestEvent()));
    }

    @Override
    public void addDecorator() {
        robot = new VigilanceDecorator(robot);
        robot = new PowerDecorator(robot);
    }
    
}
