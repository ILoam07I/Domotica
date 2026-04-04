
package observer_main_center.event;

import java.util.List;
import robot.command.InitHeat;

public class InitHeatEvent extends AbsEventImpl {
    
    public InitHeatEvent() {
        super(List.of(new InitHeat()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Iniciar Horno.";
    }

    @Override
    public String getEventInitializer() {
        return "init_heat";
    }
    
}
