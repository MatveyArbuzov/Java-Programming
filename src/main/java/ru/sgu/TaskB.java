package main.java.ru.sgu;


import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

class TaskB
{
    int[] readArray()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("\nВведите целые числа через пробел");
            String[] inputStream = scanner.nextLine().split(" ");
            int[] numbers = new int[inputStream.length];
            try
            {
                int i = 0;
                for (String element : inputStream){
                    numbers[i] = Integer.parseInt(element);
                    i++;
                }
                return numbers;
            }
            catch (Exception e)
            {
                System.out.println("Не все введённые элементы являются целыми числами");
            }
        }
    }

    OptionalInt getSecondLargest (int[] array)
    {
        if (array.length < 2)
        {
            System.out.print("Не удалось найти второй наибольший, так как в массиве меньше двух элементов");
            return OptionalInt.empty();
        }
        return Arrays.stream(array).sorted().skip(array.length-2).findFirst();
    }

    OptionalInt getThirdSmallest (int[] array)
    {
        if (array.length < 3)
        {
            System.out.print("\nНе удалось найти третий наименьший, так как в массиве меньше трёх элементов");
            return OptionalInt.empty();
        }
        return Arrays.stream(array).sorted().skip(2).findFirst();
    }

    void printElement(String message, OptionalInt el)
    {
        if(el.isPresent())
            System.out.print(message + el.getAsInt());
    }

    public static void main(String[] args)
    {
        TaskB arrayInts = new TaskB();
        int[] array = arrayInts.readArray();
        arrayInts.printElement("Второй наибольший элемент: ", arrayInts.getSecondLargest(array));
        arrayInts.printElement("\nТретий наименьший элемент: ", arrayInts.getThirdSmallest(array));
    }
}