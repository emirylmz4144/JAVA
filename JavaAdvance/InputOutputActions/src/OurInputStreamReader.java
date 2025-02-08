import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class OurInputStreamReader
{


    public void run()
    {
        try {
            FileInputStream fileInputStream=new FileInputStream("emir.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,Charset.forName("Big5"));
            System.out.println(inputStreamReader.getEncoding());

            int i=inputStreamReader.read();

            while (i!=-1)
            {
                System.out.print((char)i);
                i=inputStreamReader.read();
            }
        }catch (IOException io)
        {
            System.out.println(io.getMessage());
        }
    }
}
