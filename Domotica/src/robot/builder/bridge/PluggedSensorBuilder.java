
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.Event;
import observer_main_center.event.InitRestEvent;
import observer_main_center.event.InitVigilanceEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.VigilanceDecorator;

public class PluggedSensorBuilder extends AbsRobotBuilderImpl {
    
    @Override
    public List<? extends Event> getEvents() {
        return List.of(
                new NightModeEvent(),
                new NormalModeEvent(),
                new InitVigilanceEvent(),
                new InitRestEvent());
    }

    @Override
    public void addDecorator() {
        VigilanceDecorator vigilanceModule = new VigilanceDecorator(robot);
        robot = vigilanceModule;
        
        robot.addModule(vigilanceModule);
    }
    
}
