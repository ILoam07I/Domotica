
package robot.decorator;

import java.util.List;
import observer_main_center.event.Event;
import robot.AbsRobotImpl;
import robot.Robot;
import robot.command.Command;
import robot.state.State;

public abstract class AbsRobotDecoratorImpl extends AbsRobotImpl {
    
    protected Robot wrappee;

    public AbsRobotDecoratorImpl(Robot wrappee) {
        this.wrappee = wrappee;
    }

    public Robot getWrapee() {
        return wrappee;
    }

    public void setWrapee(Robot wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public boolean equals(Object obj) {
        return wrappee.equals(obj);
    }

    @Override
    public int compareTo(Robot o) {
        return wrappee.compareTo(o);
    }

    @Override
    public void changeToNormalMode() {
        wrappee.changeToNormalMode();
    }

    @Override
    public void changeToNightMode() {
        wrappee.changeToNightMode();
    }

    @Override
    public void changeToEcoMode() {
        wrappee.changeToEcoMode();
    }

    @Override
    public State getRobotState() {
        return wrappee.getRobotState();
    }

    @Override
    public String getId() {
        return wrappee.getId();
    }

    @Override
    public String getModelName() {
        return wrappee.getModelName();
    }

    @Override
    public List<? extends Event> getEvents() {
        return wrappee.getEvents();
    }   

    @Override
    public String describe() {
        return wrappee.describe();
    }

    @Override
    public void forceShutOff() {
        wrappee.forceShutOff();
    }

    @Override
    public void performAction(Command command) {
        wrappee.performAction(command);
    }

    @Override
    public String toString() {
        return wrappee.toString();
    }
   
}
