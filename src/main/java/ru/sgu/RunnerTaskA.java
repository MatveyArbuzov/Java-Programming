package main.java.ru.sgu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerTaskA
{
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    private void incCounter()
    {
        counter++;
    }

    private int getCounter()
    {
        return counter;
    }

    private void startTreads()
    {
        Runnable task = () -> {
            for (int i = 0; i < 50000; i++)
            {
                lock.lock();
                try
                {
                    this.incCounter();
//                    System.out.println("Значение переменной: " + counter
//                            + " текущий поток: " + Thread.currentThread().getName());
                }
                finally
                {
                    lock.unlock();
                }
            }
        };

        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);
        th1.start();
        th2.start();
        try
        {
            th1.join();
            th2.join();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }

    }

    public static void main(String []args) {
        RunnerTaskA runner = new RunnerTaskA();
        runner.startTreads();
        System.out.println("Результат работы программы: " + runner.getCounter());
    }
}