package main.java.ru.sgu;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class TaskB {

    String [] readingInputData()
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

    private boolean suitableName(File file, String targetString)
    {
        return file.getName().toLowerCase().contains(targetString);
    }

    void archivingDirWithSuitName(ZipOutputStream zip, File dir, String allPath)
    {
        File[] files = dir.listFiles();
        allPath = allPath + dir.getName() + "/";
        try {
            if (files == null || files.length == 0) {
                zip.putNextEntry(new ZipEntry(allPath));
                return;
            }
        }
        catch (Exception e)
        {
            System.out.printf("Возникла ошибка при добавлении папки %s в архив", allPath);
        }
        for (File curFile : files)
            if (curFile.isDirectory())
                archivingDirWithSuitName(zip, curFile, allPath);
            else
                this.archivingFile(zip, curFile, allPath);
    }

    void archivingDirWithoutSuitName(ZipOutputStream zip, File dir, String targetStr, String allPath, File startDir)
    {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0)
            return;
        if (dir != startDir)
            allPath = allPath + dir.getName() + "/";
        for (File curFile : files) {
            if (curFile.isDirectory())
                if (suitableName(curFile, targetStr))
                    archivingDirWithSuitName(zip, curFile, allPath);
                else
                    archivingDirWithoutSuitName(zip, curFile, targetStr, allPath, startDir);
            else
                if (suitableName(curFile, targetStr))
                    this.archivingFile(zip, curFile, allPath);
        }
    }

    void archivingFile(ZipOutputStream zip, File curFile, String allPath)
    {
        try
        {
            FileInputStream stream = new FileInputStream(curFile);
            zip.putNextEntry(new ZipEntry(allPath + curFile.getName()));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = stream.read(buffer)) > 0)
                zip.write(buffer, 0, length);
            stream.close();
            zip.closeEntry();
        }
        catch (Exception e)
        {
            System.out.printf("Возникла ошибка при добавлении файла %s в архив", allPath + curFile.getName());
        }
    }

    void archiving (String[] inputData){
        File startDir = new File(inputData[0]);
        try
        {
            ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("%s.7z".formatted(startDir.getName())));
            if (suitableName(startDir, inputData[1]))
                archivingDirWithSuitName(zip, startDir, "");
            else
                archivingDirWithoutSuitName(zip, startDir, inputData[1], "", startDir);
            zip.close();
        }
        catch (IOException e)
        {
            System.out.printf("Возникла ошибка при создании архива");
        }
    }

    public static void main(String[] args){
        TaskB run = new TaskB();
        String[] inputData = run.readingInputData();
        run.archiving(inputData);
    }

}