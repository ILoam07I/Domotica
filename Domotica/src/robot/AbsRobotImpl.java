
package robot;

import robot.state.RobotContext;

public abstract class AbsRobotImpl implements Robot {
    
    protected String modelName;
    protected String id;
    protected RobotContext robotExtension;

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
    public RobotContext getRobotExtension() {
        return robotExtension;
    }
    @Override
    public void setRobotExtension(RobotContext robotExtension) {
        this.robotExtension = robotExtension;
    }
    
}
