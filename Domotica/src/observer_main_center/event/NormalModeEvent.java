
package observer_main_center.event;

import java.util.List;
import robot.command.ChangeToNormalMode;

public class NormalModeEvent extends AbsEventImpl {
    
    public NormalModeEvent() {
        super(List.of(new ChangeToNormalMode()));
    }

    @Override
    public String getEventDescription() {
        return "[" + getEventInitializer() + "] Cambiar a Modo Normal.";
    }

    @Override
    public String getEventInitializer() {
        return "normal";
    }
    
}
