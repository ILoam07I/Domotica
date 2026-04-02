
package robot.state;

public abstract class AbsStateImpl implements State {

    @Override
    public State changeToEcoMode() {
        return new EcoMode();
    }

    @Override
    public State changeToNightMode() {
        return new NightMode();
    }

    @Override
    public State changeToNormalMode() {
        return new NormalMode();
    }
    
}
