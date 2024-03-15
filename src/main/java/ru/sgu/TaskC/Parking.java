package main.java.ru.sgu.TaskC;

public class Parking extends State
{
    Parking(AutomaticTransmission automaticTransmission) {
        super(automaticTransmission);
        automaticTransmission.setWorkingIndicator(automaticTransmission.isWorking());
        automaticTransmission.setSpeed(automaticTransmission.getSpeed());
    }
    @Override
    public String onP()
    {
        if(automaticTransmission.isWorking())
            return "Парковка уже включена";
        else{
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onR()
    {
        if(automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Reverse(automaticTransmission));
            return "Коробка переключена в режим заднего хода";
        }
        else{
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onN()
    {
        if(automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Neutral(automaticTransmission));
            return "Коробка переключена в нейтральный режим";
        }
        else{
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }

    @Override
    public String onD() {
        if(automaticTransmission.isWorking())
        {
            automaticTransmission.changeState(new Drive(automaticTransmission));
            return "Коробка переключена в основной режим";
        }
        else{
            automaticTransmission.changeState(new Еmergency(automaticTransmission));
            return "Коробка переключена в аварийный режим";
        }
    }
}
