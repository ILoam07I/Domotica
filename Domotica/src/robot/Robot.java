
package robot;

import java.util.List;
import observer_main_center.event.Event;
import robot.command.Command;
import robot.decorator.AbsRobotDecoratorImpl;
import robot.state.State;

public interface Robot extends Comparable<Robot> {
    
    public String getModelName();
    public void setModelName(String model);
    
    public String getId();
    public void setId(String id);
    
    public List<? extends Event> getEvents();
    public void setEvents(List<? extends Event> getEvents);
    
    public <M extends AbsRobotDecoratorImpl> void addModule(M module);
    
    public <M extends AbsRobotDecoratorImpl> M getModule(Class<M> type);
    
    public State getRobotState();    
    public void changeToEcoMode();
    public void changeToNightMode();
    public void changeToNormalMode();
    
    public void performAction(Command command);
    public void forceShutOff();
    public String describe();
    
    @Override
    public int compareTo(Robot o);
    @Override
    public boolean equals(Object obj);
    @Override
    public int hashCode();
    @Override
    public String toString();

}
