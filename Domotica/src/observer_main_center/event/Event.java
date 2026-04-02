
package observer_main_center.event;

import robot.command.Command;

public interface Event <C extends Command> {
    
    public C getCommand();
    
}
