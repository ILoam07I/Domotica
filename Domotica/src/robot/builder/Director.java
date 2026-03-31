
package robot.builder;

import facade.SubscriberFacade;
import java.util.List;
import observer_main_center.event.HomeAloneEvent;
import observer_main_center.event.HomeGuardedEvent;
import robot.Robot;
import robot.decorator.BatteryDecorator;
import robot.decorator.PowerDecorator;
import robot.decorator.VigilanceDecorator;

public class Director {
    
    private RobotBuilder builder;
    private SubscriberFacade subscriber;
    
    public Robot buildSmartWashingMachine(String model, String id) {
        builder = new WashingMachineBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(PowerDecorator::new);  //robot -> new PowerDecorator(robot)
        
        return builder.build();
    }
    
    public Robot buildSmartDishwasher(String model, String id) {
        builder = new DishwasherBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(PowerDecorator::new);
        
        return builder.build();
    }
    
    public Robot buildSmartOven(String model, String id) {
        builder = new OvenBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(PowerDecorator::new);
        
        return builder.build();
    }
    
    public Robot buildSmartVigilantOven(String model, String id) {
        builder = new OvenBuilder();
        subscriber = new SubscriberFacade();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(HomeAloneEvent.class, HomeGuardedEvent.class));
        
        return robot;
    }
    
    public Robot buildPluggedSensor(String model, String id) {
        builder = new GenericBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(VigilanceDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(HomeAloneEvent.class, HomeGuardedEvent.class));
        
        return robot;
    }
    
    public Robot buildSmartSensor(String model, String id) {
        builder = new GenericBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(HomeAloneEvent.class, HomeGuardedEvent.class));
        
        return robot;
    }
    
    public Robot buildSmartCleaner(String model, String id) {
        builder = new GenericBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(BatteryDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        return builder.build();
    }
    
    public Robot buildSmartVigilantCleaner(String model, String id) {
        builder = new GenericBuilder();
        
        builder.reset();
        builder.setCredentials(model, id);
        builder.addDecorator(VigilanceDecorator::new);
        builder.addDecorator(BatteryDecorator::new);
        builder.addDecorator(PowerDecorator::new);
        
        Robot robot = builder.build();
        
        subscriber.subscribe(robot, List.of(HomeAloneEvent.class, HomeGuardedEvent.class));
        
        return robot;
    }
    
}
