
package observer_main_center.event;

import java.util.List;
import robot.command.Command;

public interface Event {
    
    public List<? extends Command> getCommands();
    
    public String getEventDescription();
    
    public String getEventInitializer();
    
}
