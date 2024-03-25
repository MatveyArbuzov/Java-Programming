package main.java.ru.sgu.TaskB;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class RunnerTaskB
{
    private int readingInputNumber()
    {
        int n;
        while(true)
        {
            System.out.println("\nВведите число n");
            Scanner scanner = new Scanner(System.in);
            try
            {
                n = scanner.nextInt();
                if (n < 1)
                {
                    System.out.println("Число n должно быть больше 0");
                    continue;
                }
                return n;
            }
            catch (Exception e)
            {
                System.out.println("Необходимо ввести число");
            }
        }
    }

    private long getResult(int n)
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long res = forkJoinPool.invoke(new FibonacciViaForkJoinPool(n));
        forkJoinPool.close();
        return res;
    }

    public static void main(String []args) {
        RunnerTaskB runner = new RunnerTaskB();
        int n = runner.readingInputNumber();
        System.out.println(n + "-e число Фибоначи: " + runner.getResult(n));
    }
}


