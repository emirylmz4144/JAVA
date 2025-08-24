import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException
    {
        //içeriği alacağımız url ve url'ye bağlanma
        URL url=new URL("https://www.w3.org/TR/2003/REC-PNG-20031110/iso_8859-1.txt");
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();

        //Siteden alınan içerik için input stream oluşturuyoruz
        InputStream inputStream=connection.getInputStream();

        //Bir dosyaya yazdırma için stream oluşturuyoruz
        FileOutputStream fileOutputStream=new FileOutputStream("emir.txt");

        //Daha sonra lazım olacak bir string yapıcısı
        StringBuilder builder=new StringBuilder();

        //Veriler byte cinsi üzerinden olacağı için(ham veri almak(garanti olsun diye)) byte dizisi
        byte [] buffer=new byte[1024];
        int i=0;
        //Okumayı byte dizisi üzerinden yapacağız String yapıscısı ile byte dizisini stringe çeviriyoruz./Dosyaya içeriği yazdırıyoruz
        while ((i=inputStream.read(buffer))!=-1)
        {
            builder.append(Arrays.copyOfRange(buffer,0,i));
            fileOutputStream.write(Arrays.copyOfRange(buffer,0,i));
        }
        builder.toString();//İçeriği konsol'a yazdırıyoruz..

        //Unutma : inputStream byte inputStramReader char dizisi alır
    }
}