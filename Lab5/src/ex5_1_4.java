import java.io.*;
import java.util.Scanner;

public class ex5_1_4 {
    public static void main(String[] args) {
        try{
            // Создание исходного файла numIsh.txt и запись в него чисел типа float

            File f1=new File("C:\\Users\\m4sk\\IdeaProjects\\Lab5\\numIsh.txt");
            f1.createNewFile();

            Scanner sc = new Scanner(System.in);

            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Сколько вещественных чисел записать в файл?");
            int count = sc.nextInt();

            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++)
                wr.writeFloat(sc.nextFloat());

            wr.flush();
            wr.close();
            // Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2=new File("C:\\Users\\m4sk\\IdeaProjects\\Lab5\\numRez.txt");
            f2.createNewFile();
            // поток для чтения из исходного файла numIsh.txt
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));

            // поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            try{
                while(true){
                    float number=rd.readFloat();
                    wr.writeFloat(number);
                    System.out.println(" Число "+ number);
                }
            }catch(EOFException e){}
                wr.flush();
                wr.close();
                rd.close();
        }catch(IOException e){
            System.out.println("End of file");
        }
    }
}
