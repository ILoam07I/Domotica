
package observer_main_center.event;

import java.util.List;
import robot.command.PowerOff;

public class PowerOffEvent extends AbsEventImpl {
    
    public PowerOffEvent() {
        super(List.of(new PowerOff()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Apagar.";
    }

    @Override
    public String getEventInitializer() {
        return "off";
    }
    
}
