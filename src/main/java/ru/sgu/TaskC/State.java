package main.java.ru.sgu.TaskC;

public abstract class State {
    AutomaticTransmission automaticTransmission;

    State(AutomaticTransmission automaticTransmission) {
        this.automaticTransmission = automaticTransmission;
    }

    public abstract String onP();
    public abstract String onR();
    public abstract String onN();
    public abstract String onD();
}
