
package robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.decorator.AbsRobotDecoratorImpl;
import robot.state.NormalMode;
import robot.state.State;

public abstract class AbsRobotImpl implements Robot {
    
    protected String modelName;
    protected String id;
    protected State robotState;
    protected Map<Class<? extends AbsRobotDecoratorImpl>, AbsRobotDecoratorImpl> modules;

    public AbsRobotImpl() {
        robotState = new NormalMode();
        modules = new HashMap<>();
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
    public <M extends AbsRobotDecoratorImpl> void addModule(M module) {
        modules.put(module.getClass(), module);
    }

    @Override
    public <M extends AbsRobotDecoratorImpl> M getModule(Class<M> type) {
        AbsRobotDecoratorImpl module = modules.get(type);
        
        if (module == null) {
            return null;
        }
        
        return type.cast(module);
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
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public String toString() {
        return "\n" + id + " " + modelName;
    }
}
