package main.java.ru.sgu.TaskC;

public class Neutral extends State
{
    Neutral(AutomaticTransmission automaticTransmission) {
        super(automaticTransmission);
        automaticTransmission.setWorkingIndicator(automaticTransmission.isWorking());
        automaticTransmission.setSpeed(automaticTransmission.getSpeed());
    }
    @Override
    public String onP()
    {
        if (automaticTransmission.getSpeed() != 0)
            return "Необходимо остановиться";
        else if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Parking(automaticTransmission));
            return "Коробка переключена в режим парковки";
        }
        else
        {
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onR()
    {
        if (automaticTransmission.getSpeed() != 0)
            return "Необходимо остановиться";
        else if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Reverse(automaticTransmission));
            return "Коробка переключена в режим заднего хода";
        }
        else
        {
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onN()
    {
        if(automaticTransmission.isWorking())
            return "Нейтральный режим уже включен";
        else{
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onD() {
        if (automaticTransmission.getSpeed() != 0)
            return "Необходимо остановиться";
        else if (automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Drive(automaticTransmission));
            return "Коробка переключена в основной режим";
        }
        else
        {
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }
}
