package main.java.ru.sgu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class BigIntegerBigDecimal {

    public static void main(String[] args) {
        System.out.println("Введите параметры через пробел");
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(" ");
        scanner.close();
        if (params.length != 3) {
            System.err.println("Количество параметров должно равнятся 3");
            return;
        }
        BigDecimal a, b;
        try {
            a = new BigDecimal(params[0]);
            b = new BigDecimal(params[1]);
        } catch (NumberFormatException innerNFE) {
            System.err.println("Первые два параметра не являются числами");
            return;
        }
        try {
            switch (params[2]) {
                case  ("ADD"):
                    System.out.println(a.add(b));
                    break;
                case ("SUB"):
                    System.out.println(a.subtract(b));
                    break;
                case ("MULT"):
                    System.out.println(a.multiply(b));
                    break;
                case  ("DIV"):
                    System.out.println(a.divide(b, RoundingMode.HALF_UP));
                    break;
                case  ("REM"):
                    System.out.println(a.remainder(b));
                    break;
                case  ("POW"):
                    try {
                        BigInteger a2 = new BigInteger(params[0]);
                        int b2 = Integer.parseInt(params[1]);
                        System.out.println(a2.pow(b2));
                        break;
                    } catch (NumberFormatException innerNFE) {
                        System.err.println("Числа для операции POW должны быть целыми");
                        return;
                    }
                default:
                    System.err.println("Операция может быть следующей: ADD, SUB, MULT, DIV, REM, POW");
                    break;
            }
        } catch (ArithmeticException innerAE) {
            System.err.println("Невозможно выполнить операцию над данными числами");
        }
    }
}