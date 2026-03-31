
package robot.state;

public interface State {
    
    public boolean canHandleCommand();
    
    public int handleBattery();

    public void lock();
    
    public void release();
    
}
