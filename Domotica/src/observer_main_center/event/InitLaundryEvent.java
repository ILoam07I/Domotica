
package observer_main_center.event;

import java.util.List;
import robot.command.InitLaundry;

public class InitLaundryEvent extends AbsEventImpl {
    
    public InitLaundryEvent() {
        super(List.of(new InitLaundry()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Iniciar Lavadora.";
    }

    @Override
    public String getEventInitializer() {
        return "init_laundry";
    }
    
}
