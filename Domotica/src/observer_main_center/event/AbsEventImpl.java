
package observer_main_center.event;

import robot.command.Command;

public abstract class AbsEventImpl <C extends Command> implements Event <C> {
    
    protected C command;
    
    public AbsEventImpl(C command) {
        this.command = command;
    }

    public C getCommand() {
        return command;
    }
    
}
