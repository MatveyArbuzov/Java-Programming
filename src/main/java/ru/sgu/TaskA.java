package main.java.ru.sgu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

class TaskA
{
    Stream<Integer> readTheStream()
    {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nВведите целые числа через пробел");
            String[] inputStream = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            try{
                for (String element : inputStream)
                    list.add(Integer.parseInt(element));
                return list.stream();
            }
            catch (Exception e)
            {
                System.out.println("Не все введённые элементы являются целыми числами");
            }
        }
    }

    Stream<Integer> usingPredicate(Stream<Integer> stream, Predicate<Integer> predicate)
    {
        return stream.filter(predicate);
    }

    void printStream(Stream<Integer> stream)
    {
        System.out.print("Получены следующие числа: ");
        stream.forEach(x-> System.out.print(x + " "));
    }

    void executeWithPredicate(Predicate<Integer> predicate)
    {
        this.printStream(this.usingPredicate(this.readTheStream(), predicate));
    }

    public static void main(String[] args)
    {
        TaskA streamInts = new TaskA();
        streamInts.executeWithPredicate(x -> x % 5==0);
        streamInts.executeWithPredicate(x -> x % 2==0);
    }
}