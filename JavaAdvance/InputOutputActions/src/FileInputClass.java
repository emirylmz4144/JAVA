import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileInputClass
{
    public void ourInputClass() throws IOException {
        // Scanner sınıfının inputStrem olduğu bilindğine göre veri dışarıdan değil dosyadan alınacaktır
        try {
            Scanner input= new Scanner(new File("emir.txt"));
            while (input.hasNext())
            {
                String ourValue=input.nextLine();

                if (ourValue.contains("emir"))
                {
                    continue;
                }
                System.out.print(ourValue);
            }

        }catch (IOException ioException)
        {
            System.out.println(ioException.getMessage());
        }
        System.out.println();
        System.out.println("-------------------------------------------");



        //Byte tipinde olan input ve output streamlerin byte tipinde olduğunun kanıtı
        FileInputStream fileInputStream=new FileInputStream("emir.txt");
        System.out.println("Kullanılabilir harf(byte) sayısı: "+fileInputStream.available());
        System.out.println("-------------------------------------------");

        int i=fileInputStream.read();//Byte değeri alınır
        while (i!=-1)
        {
            /*Okuma stack/pop şeklinde gerçekleştiği için alınan veri ekrana yazdırılıp diziden atılacaktır
            * bu yüzden en sonda dosya boş olacak ve -1 değeri dönecektir
            * */

            System.out.println("Harfin Byte değeri: "+i);
            System.out.println("Harf: "+(char)i);//Byte değeri char değerine cevrilebilir
            i=fileInputStream.read();
        }

        fileInputStream.close();

    }
}
