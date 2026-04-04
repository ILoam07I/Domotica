
package observer_main_center.event;

import java.util.List;
import robot.command.InitVigilance;

public class InitVigilanceEvent extends AbsEventImpl {

    public InitVigilanceEvent() {
        super(List.of(new InitVigilance()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Activar Modo Vigilancia.";
    }

    @Override
    public String getEventInitializer() {
        return "vigilance";
    }

    
}
