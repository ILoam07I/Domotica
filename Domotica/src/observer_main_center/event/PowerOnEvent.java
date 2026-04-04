
package observer_main_center.event;

import java.util.List;
import robot.command.PowerOn;

public class PowerOnEvent extends AbsEventImpl {
    
    public PowerOnEvent() {
        super(List.of(new PowerOn()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Encender.";
    }

    @Override
    public String getEventInitializer() {
        return "on";
    }
    
}
