
package robot.builder;

import facade.SubscriberFacade;
import java.util.List;
import observer_main_center.event.InitHeatEvent;
import observer_main_center.event.InitLaundryEvent;
import observer_main_center.event.InitVigilanceEvent;
import observer_main_center.event.InitRestEvent;
import observer_main_center.event.NightModeEvent;
import observer_main_center.event.PowerOffEvent;
import observer_main_center.event.PowerOnEvent;
import observer_main_center.event.StopHeatEvent;
import observer_main_center.event.StopLaundryEvent;
import observer_main_center.event.EcoModeEvent;
import observer_main_center.event.NormalModeEvent;
import robot.Robot;
import robot.decorator.BatteryDecorator;
import robot.decorator.OvenDecorator;
import robot.decorator.PowerDecorator;
import robot.decorator.VigilanceDecorator;
import robot.decorator.WashingMachineDecorator;

public class Director {
    
    private RobotBuilder builder;
    private SubscriberFacade subscriber;

    public Director() {
        builder = new InnerBuilder();
        subscriber = new SubscriberFacade();
    }
    
    public Robot buildSmartWashingMachine(String model, String id) { 
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new EcoModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitLaundryEvent(), new StopLaundryEvent()));
        builder.addDecorator(WashingMachineDecorator::new);
        builder.addDecorator(PowerDecorator::new);  //robot -> new PowerDecorator(robot)
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, EcoModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class, InitLaundryEvent.class, StopLaundryEvent.class));
        
        return builder.build();
    }
    
    public Robot buildSmartOven(String model, String id) {
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new EcoModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitHeatEvent(), new StopHeatEvent()));
        builder.addDecorator(OvenDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, EcoModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class, InitHeatEvent.class, StopHeatEvent.class));
        
        return builder.build();
    }
    
    public Robot buildSmartVigilantOven(String model, String id) {
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new EcoModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitHeatEvent(), new StopHeatEvent(), new InitVigilanceEvent(), new InitRestEvent()));
        builder.addDecorator(OvenDecorator::new);
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, EcoModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class, InitHeatEvent.class, StopHeatEvent.class, InitVigilanceEvent.class, InitRestEvent.class));
        
        return robot;
    }
    
    public Robot buildPluggedSensor(String model, String id) {
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new NormalModeEvent(), new InitVigilanceEvent(), new InitRestEvent()));
        builder.addDecorator(VigilanceDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, NormalModeEvent.class, InitVigilanceEvent.class, InitRestEvent.class));
        
        return robot;
    }
    
    public Robot buildSmartSensor(String model, String id) {
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitVigilanceEvent(), new InitRestEvent()));
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class, InitVigilanceEvent.class, InitRestEvent.class));
        
        return robot;
    }
    
    public Robot buildSmartCleaner(String model, String id) {
        builder = new InnerBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new EcoModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent()));
        builder.addDecorator(BatteryDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, EcoModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class));
        
        return robot;
    }
    
    public Robot buildSmartVigilantCleaner(String model, String id) {
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents(List.of(new NightModeEvent(), new EcoModeEvent(), new NormalModeEvent(), new PowerOnEvent(), new PowerOffEvent(), new InitVigilanceEvent(), new InitRestEvent()));
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(BatteryDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(NightModeEvent.class, EcoModeEvent.class, NormalModeEvent.class, PowerOnEvent.class, PowerOffEvent.class, InitVigilanceEvent.class, InitRestEvent.class));
        
        return robot;
    }
    
}
