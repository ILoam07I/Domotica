
package robot.state;

public interface State {
    
    /*  Un SpecificState se podria haber referenciado desde cualquier decorador,
        no se ha hecho por simplificar.
    */
    
    public int getOvenTemperatureParam();
    public String getLaundryParam();
    public String getNoiseParam();
    
    public State changeToEcoMode();
    public State changeToNightMode();
    public State changeToNormalMode();
    
}
