import java.io.File;
import java.io.*;
import java.util.Scanner;

public class FilesData {
    public static void main(String[] args){
        try {
            File f1 = new File("numDouble.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь1: " + f1.getAbsolutePath());
            }
            Scanner sc = new Scanner(System.in);
            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.println("Сколько чисел нужно записать?");
            int count = sc.nextInt();

            System.out.println("Введите числа: ");
            for (int i = 0; i < count; i++)
                wr.writeDouble(sc.nextDouble());
            wr.flush();
            wr.close();
            File f2 = new File("numResult.txt");
            f2.createNewFile();
            if (f2.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь1: " + f2.getAbsolutePath());
            }
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
            double max = 0;
            try {
                while (true) {
                    double number = rd.readDouble();
                    if ((double) number > 0) {
                        wr.writeDouble(number);
                        System.out.println(" Число " + (double) number);
                        }
                    if((double) number > max){
                        max = ((double) number);
                    }
                }
            } catch(EOFException e){}
            wr.flush();
            wr.close();
            rd.close();
            System.out.println("Максимальное число = " + max);
        } catch (IOException e) {
                System.out.println("End of file");
            }

        }
    }