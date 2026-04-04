
package observer_main_center.event;

import java.util.List;
import robot.command.StopHeat;

public class StopHeatEvent extends AbsEventImpl {
    
    public StopHeatEvent() {
        super(List.of(new StopHeat()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Parar Horno.";
    }

    @Override
    public String getEventInitializer() {
        return "stop_heat";
    }
    
}
