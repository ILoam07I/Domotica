
package robot;

import java.util.ArrayList;
import java.util.List;
import observer_main_center.event.Event;

public abstract class AbsRobotImpl implements Robot {
    
    private List<Robot> functionalities;
    
    public AbsRobotImpl() {
        functionalities = new ArrayList<>();
    }

    @Override
    public boolean addFunctionality(Robot functionality) {
        return functionalities.add(functionality);
    }

    @Override
    public void process(Event event) {
        for (Robot func : functionalities) {
            func.process(event);
        }
    }   
    
}
