package main.java.ru.sgu.TaskA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Run
{
    Set<String> readingDataFromFile()
    {
        while(true)
        {
            System.out.println("\nНазвание файла, в котором содержатся данные");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            try
            {
                scanner = new Scanner(new File(fileName));
                Set<String> result = new LinkedHashSet<String>();
                while (scanner.hasNextLine())
                    result.add(scanner.nextLine());
                if (result.isEmpty())
                {
                    System.out.println("Указанный файл пуст");
                    continue;
                }
                scanner.close();
                return result;
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Указанный файл необходимо добавить в проект");
            }
        }
    }

    ArrayList<OwnersOfStocks> parseStrings(Set<String> inputStrings)
    {
        ArrayList<OwnersOfStocks> result = new ArrayList<OwnersOfStocks>();
        for (String element: inputStrings)
        {
            String [] currentString = element.split(" ");
            int lenStr = currentString.length;
            if (lenStr < 3 || lenStr > 5)
            {
                System.out.println("Строка \"" + element + "\" пропущена: неверное число параметров");
                continue;
            }
            String surname = currentString[0], companyName = currentString[lenStr - 2];
            int rating;
            try
            {
                rating = Integer.parseInt(currentString[lenStr - 1]);
                if (rating < 1 || rating > 10)
                {
                    System.out.println("Строка \"" + element + "\" пропущена: рейтинг должен быть от 1 до 10");
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println("Строка \"" + element + "\" пропущена: рейтинг должен быть числом");
                continue;
            }
            OwnersOfStocks ownersOfStocks = null;
            switch (lenStr)
            {
                case 3 -> ownersOfStocks =
                        new OwnersOfStocks(surname, companyName, rating);
                case 4 -> ownersOfStocks =
                        new OwnersOfStocks(surname, currentString[1], companyName, rating);
                case 5 -> ownersOfStocks =
                        new OwnersOfStocks(surname, currentString[1], currentString[2], companyName, rating);
            }
            result.add(ownersOfStocks);
        }
        return result;
    }

    ArrayList<OwnersOfStocks> sortStrings(ArrayList<OwnersOfStocks> parsedStrings)
    {
        Comparator<OwnersOfStocks> comparator =
                Comparator.comparing(OwnersOfStocks::getRating, Comparator.reverseOrder())
                        .thenComparing(OwnersOfStocks::getSurname)
                        .thenComparing(OwnersOfStocks::getName, Comparator.reverseOrder())
                        .thenComparing(OwnersOfStocks::getPatronymic);
        parsedStrings.sort(comparator);
        return parsedStrings;
    }

    void printSortedStrings(ArrayList<OwnersOfStocks> sortedStrings)
    {
        System.out.println("\nРезультат сортировки:");
        for (OwnersOfStocks ownersOfStocks : sortedStrings)
            System.out.println(ownersOfStocks.surname
                    + " " + ownersOfStocks.name
                    + " " + ownersOfStocks.patronymic
                    + " " + ownersOfStocks.companyName
                    + " " + ownersOfStocks.rating);
    }

    public static void main(String[] args)
    {
        Run run = new Run();
        Set<String> inputStrings = run.readingDataFromFile();
        ArrayList<OwnersOfStocks> parsedStrings = run.parseStrings(inputStrings);
        if (parsedStrings.isEmpty())
            System.out.println("Все строки были исключены");
        else
            run.printSortedStrings(run.sortStrings(parsedStrings));
    }
}
