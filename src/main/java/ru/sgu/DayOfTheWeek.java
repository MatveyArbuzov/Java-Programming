package main.java.ru.sgu;

import java.util.Scanner;

public class DayOfTheWeek
{
    enum Day
    {
        monday, tuesday, wednesday, thursday, friday, saturday, sunday
    }

    Day current;
    int count;

    {
        System.out.println("Введите через пробел день недели и количество дней");
        Scanner scanner = new Scanner(System.in);
        try
        {
            current = Day.valueOf(scanner.next());
            count = scanner.nextInt();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введены некорректные данные");
        }
    }

    void newDay()
    {
        count = (count + current.ordinal()) % 7;
        Day[] days = Day.values();
        System.out.println(days[count]);
    }

    public static void main(String[] args)
    {
        DayOfTheWeek object = new DayOfTheWeek();
        object.newDay();
    }
}