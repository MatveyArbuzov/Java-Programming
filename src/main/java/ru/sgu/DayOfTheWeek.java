package main.java.ru.sgu;

import java.util.InputMismatchException;
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
        this.readingData();
    }

    void readingData(){
        System.out.println("Введите через пробел день недели и количество дней");
        Scanner scanner = new Scanner(System.in);
        try
        {
            current = Day.valueOf(scanner.next());
            count = scanner.nextInt();
            if (count < 0)
                throw new ArithmeticException();
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException("Введён некорректный день недели");
        }
        catch (InputMismatchException | ArithmeticException e)
        {
            throw new RuntimeException("Второй параметр не является корректным");
        }
        scanner.close();
    }

    Day getANewDay()
    {
        count = (count + current.ordinal()) % 7;
        Day[] days = Day.values();
        return days[count];
    }

    public static void main(String[] args)
    {
        DayOfTheWeek object = new DayOfTheWeek();
        System.out.println(object.getANewDay());
    }
}
