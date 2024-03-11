package main.java.ru.sgu;

import java.util.Random;

class SpeedTest
{
    long time;
    String genString()
    {
        byte[] bytes = new byte[10];
        Random rn = new Random();
        for (int i = 0; i < 10; ++i)
            bytes[i] = (byte)(rn.nextInt(94) + 33);
        return new String(bytes);
    }
    void SpeedString()
    {
        time = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100_000; i++)
            str = str + genString();
        time = System.currentTimeMillis() - time;
        System.out.println("Время работы программы при использовании String: " + time + "ms");
    }
    void SpeedStringBuilder()
    {
        time = System.currentTimeMillis();
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < 100_000; i++)
            strBuild.append(genString());
        time = System.currentTimeMillis() - time;
        System.out.println("Время работы программы при использовании StringBuilder: " + time + "ms");
    }
    void SpeedStringBuffer()
    {
        time = System.currentTimeMillis();
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < 100_000; i++)
            strBuf.append(genString());
        time = System.currentTimeMillis() - time;
        System.out.println("Время работы программы при использовании StringBuffer: " + time + "ms");
    }

    public static void main(String[] args)
    {
        SpeedTest object = new SpeedTest();
        object.SpeedString();
        object.SpeedStringBuilder();
        object.SpeedStringBuffer();
    }
}

