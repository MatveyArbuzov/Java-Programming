package main.java.ru.sgu.TaskC;

public class Еmergency extends State
{
    Еmergency(AutomaticTransmission automaticTransmission) {
        super(automaticTransmission);
        automaticTransmission.setWorkingIndicator(automaticTransmission.isWorking());
        automaticTransmission.setSpeed(automaticTransmission.getSpeed());
    }
    @Override
    public String onP()
    {
        if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Parking(automaticTransmission));
            return "Коробка переключена в режим парковки";
        }
        else
            return "Коробка находится в аварийном режиме";
    }

    @Override
    public String onR()
    {
        if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Reverse(automaticTransmission));
            return "Коробка переключена в режим заднего хода";
        }
        else
            return "Коробка находится в аварийном режиме";
    }

    @Override
    public String onN()
    {
        if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Neutral(automaticTransmission));
            return "Коробка переключена в нейтральный режим";
        }
        else
            return "Коробка находится в аварийном режиме";
    }

    @Override
    public String onD() {
        if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Drive(automaticTransmission));
            return "Коробка переключена в основной режим";
        }
        else
            return "Коробка находится в аварийном режиме";
    }
}
