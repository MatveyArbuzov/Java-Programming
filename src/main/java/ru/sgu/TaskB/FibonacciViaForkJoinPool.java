package main.java.ru.sgu.TaskB;

import java.util.concurrent.RecursiveTask;

public class FibonacciViaForkJoinPool extends RecursiveTask<Long>
{
    private final long n;

    FibonacciViaForkJoinPool(long n)
    {
        this.n = n;
    }

    @Override
    protected Long compute()
    {
        if (n <= 1)
            return n;
        FibonacciViaForkJoinPool firstNumber = new FibonacciViaForkJoinPool(n - 1);
        firstNumber.fork();
        FibonacciViaForkJoinPool secondNumber = new FibonacciViaForkJoinPool(n - 2);
        return secondNumber.compute() + firstNumber.join();
    }
}
