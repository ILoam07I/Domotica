package robot.module;

public class PowerModule implements RobotModule {
    
    private boolean powered;

    public PowerModule() {
        this.powered = false;
    }

    public boolean isPowered() {
        return powered;
    }
    
    public void turnOn() {
        System.out.println("\t--> Iniciando secuencia de arranque.");
        powered = true;
        System.out.println("\t\tEncendido.");
    }

    @Override
    public void forceShutOff() {
        if (powered) {
            System.out.println("\t--> Iniciando secuencia de apagado.");
            powered = false;
        }
    }
    
    @Override
    public String describe() {
        return "\n\t Power[ " + (powered ? "ON" : "OFF") + " ]";
    }
}
