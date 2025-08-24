import java.io.*;
import java.util.Scanner;

public class FileOutputClass
{
    public void run()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("L�tfen bir yaz� giriniz: ");
        String text=input.nextLine();

        try {
            File file=new File("emir.txt");
            FileOutputStream fileOutputStream=new FileOutputStream(file);

            fileOutputStream.write(text.getBytes());

        } catch (IOException io)
        {
            System.out.println(io.getMessage());
        }


    }
}
