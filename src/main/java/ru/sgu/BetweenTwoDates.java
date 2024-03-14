package main.java.ru.sgu;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

class BetweenTwoDates
{
    LocalDate firstDate, secondDate;

    void readDates()
    {
        firstDate = this.readOneDate();
        secondDate = this.readOneDate();
    }

    LocalDate readOneDate()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Введите через пробел год, месяц и день");
            try
            {
                int year, month, day;
                year = scanner.nextInt();
                if (year < 1){
                    System.out.println("Введён некорректный год");
                    continue;
                }
                month = scanner.nextInt();
                if (month < 1 || month > 12){
                    System.out.println("Введён некорректный месяц");
                    continue;
                }
                day = scanner.nextInt();
                if (day < 1 || day > 31){
                    System.out.println("Введён некорректный день");
                    continue;
                }
                return LocalDate.of(year, month, day);
            }
            catch (Exception e)
            {
                System.out.println("Введена некорректная дата");
            }
        }
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
        BetweenTwoDates dates = new BetweenTwoDates();
        dates.readDates();
        System.out.printf("Между введёнными датами прошло %d дней", dates.daysBetween());
    }
}
