package main.java.ru.sgu.TaskC;
//Есть продюсер, который кладет данные в очередь (название еды + число килокалорий).
//
//Есть несколько потребителей, которые забирают данные из очереди. При заборе потребитель выводит,
// какой товар он только что съел, и сколько килокалорий суммарно он употребил.


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
    private final String name;
    private int curSumCalories = 0;
    private final int neededSumCalories;
    private final BlockingQueue<Product> queue;

    public Consumer(String name, int neededSumCalories, BlockingQueue<Product> queue)
    {
        this.name = name;
        this.neededSumCalories = neededSumCalories;
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            while (curSumCalories < neededSumCalories)
            {
                Product product = queue.take();
                curSumCalories += product.getCalories();
                System.out.println(name + " съел " + product.getName()
                        + ", килокалорий употреблено: " + curSumCalories + "/" + neededSumCalories);
                if (curSumCalories >= neededSumCalories)
                    System.out.println(name + " наелся/наелась");
                else
                    Thread.sleep(500);
            }

        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}