package main.java.ru.sgu;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

class BetweenTwoDates
{
    LocalDate firstDate, secondDate;

    {
        firstDate = this.takeDate();
        secondDate = this.takeDate();
    }
    LocalDate takeDate()
    {
        System.out.println("Введите через пробел год, месяц и день");
        Scanner scanner = new Scanner(System.in);
        LocalDate date;
        try
        {
            date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введена некорректная дата");
        }
        return date;
    }
    long daysBetween()
    {
        if(firstDate.isAfter(secondDate))
            return ChronoUnit.DAYS.between(secondDate, firstDate);
        else
            return ChronoUnit.DAYS.between(firstDate, secondDate);
    }

    public static void main(String[] args)
    {
        BetweenTwoDates object = new BetweenTwoDates();
        System.out.printf("Между введёнными датами прошло %d дней", object.daysBetween());

    }
}


