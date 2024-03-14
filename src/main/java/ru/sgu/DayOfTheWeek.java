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

    void readingData(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите через пробел день недели и количество дней");
            try
            {
                current = Day.valueOf(scanner.next());
                count = scanner.nextInt();
                if (count < 0)
                    throw new ArithmeticException();
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Введён некорректный день недели");
            }
            catch (InputMismatchException | ArithmeticException e)
            {
                System.out.println("Второй параметр не является корректным");
            }
        }
    }

    Day getANewDay()
    {
        count = (count + current.ordinal()) % 7;
        Day[] days = Day.values();
        return days[count];
    }

    public static void main(String[] args)
    {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        dayOfTheWeek.readingData();
        System.out.println(dayOfTheWeek.getANewDay());
    }
}
