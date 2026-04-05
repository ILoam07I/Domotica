
package robot.builder.bridge;

import java.util.List;
import observer_main_center.event.EcoModeEvent;
import observer_main_center.event.Event;
import observer_main_center.event.InitHeatEvent;
import observer_main_center.event.InitRestEvent;
import observer_main_center.event.InitVigilanceEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.NormalModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import observer_main_center.event.StopHeatEvent;
import robot.builder.AbsRobotBuilderImpl;
import robot.decorator.OvenDecorator;
import robot.decorator.PowerDecorator;
import robot.decorator.VigilanceDecorator;

public class SmartVigilantOvenBuilder extends AbsRobotBuilderImpl {

    @Override
    public List<? extends Event> getEvents() {
        return List.of(
                new NightModeEvent(),
                new EcoModeEvent(),
                new NormalModeEvent(),
                new PowerOnEvent(),
                new PowerOffEvent(),
                new InitHeatEvent(),
                new StopHeatEvent(),
                new InitVigilanceEvent(),
                new InitRestEvent());
    }

    @Override
    public void addDecorator() {
        OvenDecorator ovenModule = new OvenDecorator(robot);
        robot = ovenModule;
        VigilanceDecorator vigilanceModule = new VigilanceDecorator(robot);
        robot = vigilanceModule;
        PowerDecorator powerModule = new PowerDecorator(robot);
        robot = powerModule;
        
        robot.addModule(ovenModule);
        robot.addModule(vigilanceModule);
        robot.addModule(powerModule);
    }
    
}
