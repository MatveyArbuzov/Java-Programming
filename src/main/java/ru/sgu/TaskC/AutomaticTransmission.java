package main.java.ru.sgu.TaskC;

public class AutomaticTransmission
{
    private State state;
    private boolean workingIndicator = false;
    private int speed = 0;

    public AutomaticTransmission()
    {
        this.state = new Parking(this);
        setWorkingIndicator(true);
    }

    public void changeState(State state)
    {
        this.state = state;
    }

    public State getState()
    {
        return state;
    }

    public void setWorkingIndicator(boolean indicator)
    {
        this.workingIndicator = indicator;
    }

    public boolean isWorking() {
        return workingIndicator;
    }

    public void setSpeed(int value)
    {
        this.speed = value;
    }

    public int getSpeed() {
        return speed;
    }
}
