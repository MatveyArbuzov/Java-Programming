package main.java.ru.sgu.TaskA;

public class OwnersOfStocks {
    String surname, name, patronymic, companyName;
    int rating;

    public OwnersOfStocks(String surname, String name, String patronymic, String companyName, int rating)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.companyName = companyName;
        this.rating = rating;
    }

    public OwnersOfStocks(String surname, String name, String companyName, int rating)
    {
        this(surname, name, "", companyName, rating);
    }

    public OwnersOfStocks(String surname, String companyName, int rating)
    {
        this(surname, "", "", companyName, rating);
    }

    public String getSurname()
    {
        return surname;
    }

    public String getName()
    {
        return name;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public int getRating()
    {
        return rating;
    }
}
