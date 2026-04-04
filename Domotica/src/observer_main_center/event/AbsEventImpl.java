
package observer_main_center.event;

import java.util.ArrayList;
import java.util.List;
import robot.command.Command;

public abstract class AbsEventImpl implements Event {
    
    protected List<? extends Command> commands;
    
    public AbsEventImpl(List<? extends Command> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public List<? extends Command> getCommands() {
        return commands;
    }
    
    @Override
    public boolean equals(Object o) {
        return this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}
