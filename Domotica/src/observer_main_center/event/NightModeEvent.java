
package observer_main_center.event;

import java.util.List;
import robot.command.ChangeToNightMode;

public class NightModeEvent extends AbsEventImpl {
    
    public NightModeEvent() {
        super(List.of(new ChangeToNightMode()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Cambiar a Modo Noche.";
    }

    @Override
    public String getEventInitializer() {
        return "night";
    }
    
}
