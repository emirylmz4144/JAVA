import java.util.*;


public class Main {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Kelime giriniz: (Türkçe karakter kullanmayiniz) ");
        String word=input.nextLine();
        word=word.replaceAll("\\s","");//Kelimelerdeki boşluklar silinerek ASCII'de bulunmayan karakterin olmaması sağlanır

        int [] alfabe=new int[26];//İngilizce alfabede bulunan harfler kadar bir dizi oluşturulur
        for (int i=0;i<word.length();i++)
        {
            //Türkçe karakterler alfabe dizisinin boyutundan uzun olacağından kullanılırsa hata fırlatmalı
            if ((int) kelime.charAt(i) > 26)
                throw new Exception("Türkçe karakter kullanmayınız");
            else
                alfabe[((int) word.charAt(i)) - 97]++;//Her karakterin ASCII numarasından ASCII alfabesinin başlangıç değeri çıkarılır
        }

        for (int i=0; i< alfabe.length;i++)
        {
            if (alfabe[i]!=0)
                System.out.println(((char)(i+97))+" "+ alfabe[i]);
        }

    }


}