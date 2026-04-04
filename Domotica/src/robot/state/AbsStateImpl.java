
package robot.state;

public abstract class AbsStateImpl implements State {

    @Override
    public State changeToEcoMode() {
        System.out.println("\t--> Cambiando a Modo Eco.");
        return new EcoMode();
    }

    @Override
    public State changeToNightMode() {
        System.out.println("\t--> Cambiando a Modo Noche.");
        return new NightMode();
    }

    @Override
    public State changeToNormalMode() {
        System.out.println("\t--> Cambiando a Modo Normal.");
        return new NormalMode();
    }
    
}
