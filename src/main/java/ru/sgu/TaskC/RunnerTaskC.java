package main.java.ru.sgu.TaskC;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RunnerTaskC
{
    public static void main(String[] args) {
        BlockingQueue<Product> queue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer("Алиса", 1000, queue);
        Consumer consumer2 = new Consumer("Боб", 1500, queue);
        Consumer consumer3 = new Consumer("Трент", 2000, queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        Thread consumerThread3= new Thread(consumer3);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        try {
            consumerThread1.join();
            consumerThread2.join();
            consumerThread3.join();

            producerThread.interrupt();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
