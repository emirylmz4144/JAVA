import java.io.IOException;

public class PrintStream
{
    public void run()
    {
        try {

            java.io.PrintStream output=new java.io.PrintStream("emir.txt");// Stream olu�tu

            output.println("Merhabalar �u an kendimize ait bir stream olu�turuyoruz.."); //stream'e ait ��kt� verildi..

            System.out.printf("Merhabalar �u an kendimize ait bir stream olu�turuyoruz..");//systeme ait stream'e yaz� yaz�ld�

            // out--> systeme ait stream
            // output --> bize ait stream
        }

        catch (IOException io)
        {
            System.out.println("yazma ger�ekle�emedi..");
        }
    }
}
