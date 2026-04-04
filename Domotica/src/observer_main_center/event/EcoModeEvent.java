
package observer_main_center.event;

import java.util.List;
import robot.command.ChangeToEcoMode;

public class EcoModeEvent extends AbsEventImpl {
    
    public EcoModeEvent() {
        super(List.of(new ChangeToEcoMode()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Cambiar a Modo Eco.";
    }

    @Override
    public String getEventInitializer() {
        return "eco";
    }
    
}
