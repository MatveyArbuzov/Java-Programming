package main.java.ru.sgu;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

class BetweenTwoDates
{
    LocalDate firstDate, secondDate;

    {
        firstDate = this.readDate();
        secondDate = this.readDate();
    }

    LocalDate readDate()
    {
        System.out.println("Введите через пробел год, месяц и день");
        Scanner scanner = new Scanner(System.in);
        LocalDate date;
        int year, month, day;
        try
        {
            year = scanner.nextInt();
            if (year < 1)
                throw new ArithmeticException();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введён некорректный год");
        }
        try
        {
            month = scanner.nextInt();
            if (month < 1 || month > 12)
                throw new ArithmeticException();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введён некорректный месяц");
        }
        try
        {
            day = scanner.nextInt();
            if (day < 1 || day > 31)
                throw new RuntimeException("Введён некорректный день");
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введён некорректный день");
        }
        try
        {
            date = LocalDate.of(year, month, day);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Введена некорректная дата");
        }
        scanner.close();
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
