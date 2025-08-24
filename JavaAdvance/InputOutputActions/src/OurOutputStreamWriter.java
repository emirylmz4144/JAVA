import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OurOutputStreamWriter
{
    public void run()
    {

        try {
            FileOutputStream fileOutputStream=new FileOutputStream("emir.txt");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"Big5");


            outputStreamWriter.write("Merhabalar efendim ben muhammed emir yýlmaz");

            outputStreamWriter.close();
            fileOutputStream.close();

        }catch (IOException io)
        {
            System.out.println(io.getMessage());
        }
    }
}
