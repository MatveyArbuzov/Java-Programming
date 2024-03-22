package main.java.ru.sgu.TaskA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RunnerTaskA
{
    private void printError(String message)
    {
        System.err.println(message);
    }

    private Set<String> readingDataFromFile()
    {
        while(true)
        {
            System.out.println("\nНазвание файла, в котором содержатся данные");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            try
            {
                scanner = new Scanner(new File(fileName));
            }
            catch (FileNotFoundException ex)
            {
                printError("Указанный файл необходимо добавить в проект");
                continue;
            }
            Set<String> result = new LinkedHashSet<String>();
            while (scanner.hasNextLine())
                result.add(scanner.nextLine());
            if (result.isEmpty())
               printError("Указанный файл пуст");
            else
            {
                scanner.close();
                return result;
            }
        }
    }

    private ArrayList<StockOwner> parseStrings(Set<String> inputStrings)
    {
        ArrayList<StockOwner> result = new ArrayList<StockOwner>();
        for (String element: inputStrings)
        {
            String [] currentString = element.split(" ");
            int lenStr = currentString.length;
            if (lenStr < 3 || lenStr > 5)
                printError("Строка \"" + element + "\" пропущена: неверное число параметров");
            else
            {
                String surname = currentString[0], companyName = currentString[lenStr - 2];
                int rating;
                try
                {
                    rating = Integer.parseInt(currentString[lenStr - 1]);
                    if (rating < 1 || rating > 10)
                        printError("Строка \"" + element + "\" пропущена: рейтинг должен быть от 1 до 10");
                    else
                    {
                        StockOwner stockOwner = null;
                        switch (lenStr)
                        {
                            case 3 -> stockOwner =
                                    new StockOwner(surname, companyName, rating);
                            case 4 -> stockOwner =
                                    new StockOwner(surname, currentString[1], companyName, rating);
                            case 5 -> stockOwner =
                                    new StockOwner(surname, currentString[1], currentString[2], companyName, rating);
                        }
                        result.add(stockOwner);
                    }
                }
                catch (Exception e)
                {
                    printError("Строка \"" + element + "\" пропущена: рейтинг должен быть числом");
                }
            }
        }
        return result;
    }

    private ArrayList<StockOwner> sortStrings(ArrayList<StockOwner> parsedStrings)
    {
        Comparator<StockOwner> comparator =
                Comparator.comparing(StockOwner::getRating, Comparator.reverseOrder())
                        .thenComparing(StockOwner::getSurname)
                        .thenComparing(StockOwner::getName, Comparator.reverseOrder())
                        .thenComparing(StockOwner::getPatronymic);
        parsedStrings.sort(comparator);
        return parsedStrings;
    }

    private void printSortedStrings(ArrayList<StockOwner> sortedStrings)
    {
        System.out.println("\nРезультат сортировки:");
        for (StockOwner stockOwner : sortedStrings)
            System.out.println(stockOwner.toString());
    }

    public static void main(String[] args)
    {
        RunnerTaskA run = new RunnerTaskA();
        Set<String> inputStrings = run.readingDataFromFile();
        ArrayList<StockOwner> parsedStrings = run.parseStrings(inputStrings);
        if (parsedStrings.isEmpty())
            System.out.println("Все строки были исключены");
        else
            run.printSortedStrings(run.sortStrings(parsedStrings));
    }
}
