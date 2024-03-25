package main.java.ru.sgu.TaskC;

public class Product
{
    private final String name;
    private final int calories;

    public Product(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
