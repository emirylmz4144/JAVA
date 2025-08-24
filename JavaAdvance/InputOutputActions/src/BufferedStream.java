import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedStream
{
    public void run()
    {
        long startTimeWithoutBuffered=System.nanoTime();


        try {
            FileInputStream fileInputStream=new FileInputStream("emir.txt");

            int i=fileInputStream.read();

            while (i!=-1)
            {
                System.out.print((char) i);
                i=fileInputStream.read();
            }
            fileInputStream.close();
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


        long finishTimeWithoutBuffered=System.nanoTime();

        long time=(finishTimeWithoutBuffered-startTimeWithoutBuffered);
        System.out.println("\nBuffered Input Stream yokken: "+time);


        System.out.println("------------------------------------");

        long startTimeWithBuffered=System.nanoTime();


        try {
            FileInputStream fileInputStream=new FileInputStream("emir.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            int i=bufferedInputStream.read();

            while (i!=-1)
            {
                System.out.print((char) i);
                i=bufferedInputStream.read();
            }
            bufferedInputStream.close();
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


        long finishTimeWithBuffered=System.nanoTime();

        long bufferedTime=(finishTimeWithBuffered-startTimeWithBuffered);
        System.out.println("\nBuffered olunc: "+bufferedTime);


        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        System.out.println("Tampon görevi gören buffered'ýn zamana etkisi "+(time-bufferedTime)+" nanosaniyedir");
    }
}
