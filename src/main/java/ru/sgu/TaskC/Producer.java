package main.java.ru.sgu.TaskC;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
    private final BlockingQueue<Product> queue;

    private final Product[] products = new Product[]{
            new Product("Макароны с фаршем", 195),
            new Product("Яишница", 300),
            new Product("Киви", 38),
            new Product("Кешью", 110),
            new Product("Хлеб", 170),
            new Product("Салат Цезарь", 44),
            new Product("Вода", 0),
            new Product("Картофель фри", 255),
            new Product("Бифштекс", 203),
            new Product("Шоколадное пирожное", 397),
            new Product("Мороженое Страчателла", 150),
            new Product("Сырный суп", 51),
            new Product("Пюре", 200),
            new Product("Гречка", 310),
            new Product("Cola", 210),
            new Product("Пицца Пепперони", 494),
            new Product("Борщ", 57),
    };

    public Producer(BlockingQueue<Product> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Random random = new Random();
                Product product = products[random.nextInt(products.length)];
                queue.put(product);
                Thread.sleep(300);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
