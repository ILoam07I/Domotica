
package observer_main_center.event;

import java.util.List;
import robot.command.StopLaundry;

public class StopLaundryEvent extends AbsEventImpl {
    
    public StopLaundryEvent() {
        super(List.of(new StopLaundry()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Parar Lavadora.";
    }

    @Override
    public String getEventInitializer() {
        return "stop_laundry";
    }
    
}
