package main.java.ru.sgu.TaskA;

public class StockOwner {
    String surname, name, patronymic, companyName;
    int rating;

    public StockOwner(String surname, String name, String patronymic, String companyName, int rating)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.companyName = companyName;
        this.rating = rating;
    }

    public StockOwner(String surname, String name, String companyName, int rating)
    {
        this(surname, name, "", companyName, rating);
    }

    public StockOwner(String surname, String companyName, int rating)
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

    public String getCompanyName()
    {
        return companyName;
    }

    public int getRating()
    {
        return rating;
    }

    @Override
    public String toString() {
        return this.surname
                + " " + this.name
                + " " + this.patronymic
                + " " + this.companyName
                + " " + this.rating;
    }
}
