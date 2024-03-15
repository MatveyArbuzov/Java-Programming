package main.java.ru.sgu.TaskC;

public class Run {
    public static void main(String[] args) {
        AutomaticTransmission automaticTransmission = new AutomaticTransmission();
        UI ui = new UI(automaticTransmission);
        ui.init();
    }
}
