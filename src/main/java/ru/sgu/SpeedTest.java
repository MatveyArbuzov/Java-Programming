package main.java.ru.sgu;

import java.util.Random;

class SpeedTest
{
    String genString()
    {
        byte[] bytes = new byte[10];
        Random rn = new Random();
        for (int i = 0; i < 10; ++i)
            bytes[i] = (byte)(rn.nextInt(94) + 33);
        return new String(bytes);
    }

    void execWithString()
    {
        String str = "";
        for (int i = 0; i < 100_000; i++)
            str = str + genString();
    }

    void execWithStringBuilder()
    {
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < 100_000; i++)
            strBuild.append(genString());
    }

    void execWithStringBuffer()
    {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < 100_000; i++)
            strBuf.append(genString());
    }

    long getTimeOfMethod(int i){
        long time;
            time = System.currentTimeMillis();
            switch (i){
                case 1:
                    this.execWithString();
                    break;
                case 2:
                    this.execWithStringBuilder();
                    break;
                case 3:
                    this.execWithStringBuffer();
                    break;
            }
            return System.currentTimeMillis() - time;
    }

    public static void main(String[] args)
    {
        SpeedTest object = new SpeedTest();
        System.out.println("Время работы программы при использовании String: "
                + object.getTimeOfMethod(1) + "ms");
        System.out.println("Время работы программы при использовании StringBuilder: "
                + object.getTimeOfMethod(2) + "ms");
        System.out.println("Время работы программы при использовании StringBuffer: "
                + object.getTimeOfMethod(3) + "ms");
    }
}
