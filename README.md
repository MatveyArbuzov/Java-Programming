Задание 7
---
Была выбрана база данных Postgres. Решение необходимо сделать на уровне Java (через sql-запросы на JDBC).

A. Дана таблица employeesAge

  id employeeName age

  0 Кирилл 18

  1 Саша 20

  2 Катя 25

Необходимо вывести всех сотрудников, чей возраст больше 20.


B. Дана таблица departmentSalary

id employeeName departmentName salary

0 Кирилл IT 30000

1 Иван IT 20000

2 Маша HR 40000


Необходимо вывести среднюю зарплату по каждому отделу.

Пример:

departmentName averageSalary

IT 25000

HR 40000


C. Даны таблицы departmentEmployee

id employeeName departmentId

0 Кирилл 1

1 Иван 1

2 Маша 2


и departmentLocation

departmentId departmentName location

1 IT Саратов

2 HR Москва


Для каждого сотрудника необходимо вывести имя его департамента и локацию работы.
employeeName departmentName location
Кирилл IT Саратов
Иван IT Калифорния
Маша HR Москва
