
package observer_main_center.event;

import java.util.List;
import robot.command.InitRest;

public class InitRestEvent extends AbsEventImpl {

    public InitRestEvent() {
        super(List.of(new InitRest()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Activar Modo Descanso";
    }

    @Override
    public String getEventInitializer() {
        return "rest";
    }

    
}
