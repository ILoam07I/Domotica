
package robot.builder;

import java.util.Map;
import java.util.function.Supplier;
import robot.builder.bridge.PluggedSensorBuilder;
import robot.builder.bridge.SmartOvenBuilder;
import robot.builder.bridge.SmartSensorBuilder;
import robot.builder.bridge.SmartVigilantCleanerBuilder;
import robot.builder.bridge.SmartVigilantOvenBuilder;
import robot.builder.bridge.SmartWashingMachineBuilder;
import robot.builder.facade.SubscriberFacade;

public class Director <B extends RobotBuilder> {
    
    public static final Map<String, Supplier<RobotBuilder>> PROTS = Map.of(
            "smart_oven", SmartOvenBuilder::new,
            "smart_vigilant_oven", SmartVigilantOvenBuilder::new,
            "smart_washing_machine", SmartWashingMachineBuilder::new,
            "plugged_sensor", PluggedSensorBuilder::new,
            "smart_sensor", SmartSensorBuilder::new,
            "smart_vigilant_cleaner", SmartVigilantCleanerBuilder::new);
    
    private B builder;
    private SubscriberFacade subscriber;
    
    public Director(Supplier<RobotBuilder> builderSupplier) {
        this.builder = (B) builderSupplier.get();
        subscriber = new SubscriberFacade();
    }

    public Director(B builder) {
        this.builder = builder;
        subscriber = new SubscriberFacade();
    }
    
    public void buildRobot(String model, String id) {        
        builder.reset();
        builder.setCredentials(model, id);
        builder.setEvents();
        builder.addDecorator();
        
        subscriber.subscribe(builder.build());
    }
    
}
