package main.java.ru.sgu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NameAndInitials {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] params = scanner.nextLine().split(" ");
                if (params.length == 1 && params[0].isEmpty()){
                    System.out.println(params[0]);
                    continue;
                }
                if (params.length < 3){
                    System.out.println("В строке отсутствуют необходимые поля");
                    continue;
                }
                boolean checker = true;
                for (int i = 0; i < 3; i++){
                    String str = params[i].charAt(0) + "";
                    if (!Pattern.matches("[a-zA-Zа-яА-Я]+", params[i]) || str != str.toUpperCase()){
                        System.out.println("Некорректные данные в полях Имя, Фамилия, Отчество");
                        checker = false;
                        break;
                    }
                }
                if (checker){
                    String res = params[1] + " " + params[0].charAt(0) + "." + params[2].charAt(0) + ".";
                    System.out.println(res);
                }
            }
            scanner.close();
        }catch (FileNotFoundException ex){
            System.err.println("Указанный файл не существует");
        }
    }
}
