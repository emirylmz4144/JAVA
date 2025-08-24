import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)
    {

        SortedMap<Integer,String> ourStudentInformations=new TreeMap<>();//Sıralanmış bir Map haritası oluşturulur
        File file=new File("InformationsOfStudent.txt");//Dosyadan veriler çekilir
        try {

            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=null;
            while ((line=bufferedReader.readLine())!=null)
            {
                String [] toMap =line.split(" ");//Çekilen veriler istenilen formatta parse edilir
                ourStudentInformations.put(Integer.parseInt(toMap[0]),toMap[1]);//parse edilen veriler map'e eklenir
            }
        }catch (IOException ioException)
        {  System.out.println(ioException.getMessage());}


        for (int i:ourStudentInformations.keySet())//Map'te var olan veriler key-value değerlerine göre yazdırılır
            System.out.println("Anahtar değer: "+i+" Anahtarın karşılık geldiği değer: "+ourStudentInformations.get(i));

    }
}