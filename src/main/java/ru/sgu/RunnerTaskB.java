package main.java.ru.sgu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class RunnerTaskB {

    private String [] readingInputData()
    {
        while(true)
        {
            System.out.println("\nВведите через новую строку относительный путь до директории и целевую строку");
            Scanner scanner = new Scanner(System.in);
            String[] res = new String[2];
            for (int i = 0; i < 2; i++)
                res[i] = scanner.nextLine();
            if (res[0].isEmpty() || res[1].isEmpty())
            {
                System.out.println("Один из параметров пуст");
                continue;
            }
            File directory = new File(res[0]);
            if (!directory.isDirectory()) {
                System.out.println("Введённый путь не указывает на директорию");
                continue;
            }
            scanner.close();
            return res;
        }
    }

    private void archivingEmptyDirectory(ZipOutputStream zip, File dir, int lenStartDir)
    {
        File[] files = dir.listFiles();
        try {
            if (files == null || files.length == 0)
                zip.putNextEntry(new ZipEntry(dir.getPath().substring(lenStartDir) + "/"));
        }
        catch (Exception e)
        {
            System.out.printf("Возникла ошибка при добавлении папки %s в архив: ошибка ввода/вывода", dir.getPath());
        }
    }

    private void archivingFile(ZipOutputStream zip, File curFile, int lenStartDir)
    {
        try
        {
            FileInputStream stream = new FileInputStream(curFile);
            zip.putNextEntry(new ZipEntry(curFile.getPath().substring(lenStartDir)));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = stream.read(buffer)) > 0)
                zip.write(buffer, 0, length);
            stream.close();
            zip.closeEntry();
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("Возникла ошибка при добавлении файла %s в архив: не удалось прочитать"
                    , curFile.getPath());
        }
        catch (IOException e)
        {
            System.out.printf("Возникла ошибка при добавлении файла %s в архив: ошибка ввода/вывода", curFile.getPath());
        }
    }

    private void archiving(ZipOutputStream zip, Path startPath, String targetStr, int lenStartDir) {
        try {
            List<Path> pathsList = Files.walk(startPath)
                    .filter(p -> p.toString().toLowerCase().contains(targetStr))
                    .toList();
            for (Path curPath : pathsList){
                File curFile = new File(String.valueOf(curPath));
                if (curFile.isDirectory())
                    archivingEmptyDirectory(zip, curFile, lenStartDir);
                else
                    archivingFile(zip, curFile, lenStartDir);
            }
        }
        catch (IOException e)
        {
            System.err.println("Возникла ошибка ввода/вывода при обращении к директории " + startPath);
        }

    }

    private void startArchiving(String[] inputData){
        try
        {
            ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("%s.7z".formatted(inputData[0])));
            archiving(zip, Paths.get(inputData[0]), inputData[1], inputData[0].length() + 1);
            zip.close() ;
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Возникла ошибка при создании архива: " +
                    "Существует каталог с данным именем или недостаточно прав");
        }
        catch (IOException e)
        {
            System.err.println("Возникла ошибка при закрытии архива: архив не существует");
        }
    }

    public static void main(String[] args){
        RunnerTaskB run = new RunnerTaskB();
        String[] inputData = run.readingInputData();
        run.startArchiving(inputData);
    }
}
