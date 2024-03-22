package main.java.ru.sgu;

import java.sql.*;


public class RunnerTask7 {

    private void getResTaskA(Statement statement) throws java.sql.SQLException
    {
        ResultSet resultSet = ((Statement) statement).executeQuery("""
            SELECT *
            FROM employeesAge
            WHERE age > 20;
            """);
        System.out.println("Все сотрудники, чей возраст больше 20:");
        while (resultSet.next())
            System.out.println(resultSet.getString("employeeName"));
    }

    private void getResTaskB(Statement statement) throws java.sql.SQLException
    {
        ResultSet resultSet = ((Statement) statement).executeQuery("""
                SELECT departmentName, Avg(salary) as averageSalary
                FROM departmentSalary
                GROUP BY departmentName;
                """);
        System.out.println("\nСредняя зарплата по каждому отделу:");
        while (resultSet.next())
            System.out.println(resultSet.getString("departmentName")
                    + " " + resultSet.getInt("averageSalary"));
    }

    private void getResTaskC(Statement statement) throws java.sql.SQLException
    {
        ResultSet resultSet = ((Statement) statement).executeQuery("""
                SELECT employeeName, departmentName, location
                FROM departmentEmployee as table1, departmentLocation as table2
                WHERE table1.departmentId = table2.departmentId;
                """);
        System.out.println("\nСотрудник, его департамент и локация работы:");
        while (resultSet.next())
            System.out.println(resultSet.getString("employeeName")
                    + " " + resultSet.getString("departmentName")
                    + " " + resultSet.getString("location"));
    }

    public static void main(String[] args) throws java.sql.SQLException {
        RunnerTask7 runner = new RunnerTask7();
        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/DBForTask7", "postgres", "bmw123");
        Statement statement = connection.createStatement();
        runner.getResTaskA(statement);
        runner.getResTaskB(statement);
        runner.getResTaskC(statement);
        connection.close();
    }
}