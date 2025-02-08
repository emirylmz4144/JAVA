import java.io.IOException;

public class PrintStream
{
    public void run()
    {
        try {

            java.io.PrintStream output=new java.io.PrintStream("emir.txt");// Stream oluþtu

            output.println("Merhabalar þu an kendimize ait bir stream oluþturuyoruz.."); //stream'e ait çýktý verildi..

            System.out.printf("Merhabalar þu an kendimize ait bir stream oluþturuyoruz..");//systeme ait stream'e yazý yazýldý

            // out--> systeme ait stream
            // output --> bize ait stream
        }

        catch (IOException io)
        {
            System.out.println("yazma gerçekleþemedi..");
        }
    }
}
