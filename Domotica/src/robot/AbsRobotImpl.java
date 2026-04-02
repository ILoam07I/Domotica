
package robot;

import java.util.ArrayList;
import java.util.List;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.state.NormalMode;
import robot.state.State;

public abstract class AbsRobotImpl implements Robot, Comparable <Robot> {
    
    protected String modelName;
    protected String id;
    protected State robotState;
    protected List<Event> events;

    public AbsRobotImpl() {
        robotState = new NormalMode();
        events = new ArrayList<>();
    }

    @Override
    public String getModelName() {
        return modelName;
    }
    @Override
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public State getRobotState() {
        return robotState;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }
    @Override
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public void performAction(Command command) {
        command.execute(this);
    }

    @Override
    public void forceShutOff() {}
    
    @Override
    public String describe() {
        return toString();
    }

    @Override
    public void changeToEcoMode() {
        robotState = robotState.changeToEcoMode();
    }

    @Override
    public void changeToNightMode() {
        robotState = robotState.changeToNightMode();
    }

    @Override
    public void changeToNormalMode() {
        robotState = robotState.changeToNormalMode();
    }

    @Override
    public int compareTo(Robot o) {
        return this.id.compareTo(o.getId());
    }
    
    @Override
    public boolean equals(Object obj) {
        Robot o = (Robot) obj;
        
        return id.equalsIgnoreCase(o.getId());
    }
    
    @Override
    public String toString() {
        return id + " " + modelName;
    }
}
