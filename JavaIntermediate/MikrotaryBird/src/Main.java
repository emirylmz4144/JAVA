import java.util.*;

public class Main
{
    static  Scanner input=new Scanner(System.in);
    public static void main(String[] args)
    {

        int count =input.nextInt();// Dizinin boyutu alınıyor
        int [] ourArray=new int [count];//Dizi tanımlanıyor

        //Kullanıcıdan alınan değerler diziye aktarılıyor
        for (int i=0;i<count;i++)
        {
            int value=input.nextInt();
            ourArray[i]=value;
        }


        int [] mikrotaryBird=mikrotaryCounter(ourArray);//İlgili bilgiler ilgili fonksiyondadır.

        int maxMikrotaryCounter=1;//en fazla tekrar eden elemanın tekrar sayısınınn atandığı değişken
        int mikrotaryCounterValue=ourArray[0];// en fazla tekrar eden elemanın atandığı değişken


        for (int i=0;i<mikrotaryBird.length;i++)
        {
            if (mikrotaryBird[i]>maxMikrotaryCounter)//ilgili indisdeki elemanın ne kadar tekrar ettiğini karşılaştırıyoruz
            {
                maxMikrotaryCounter=mikrotaryBird[i];// Şart sağlandıysa tekrar sayısını yeni max tekrar eden miktarı yapıyoruz
                mikrotaryCounterValue=ourArray[i];// ve en fazla tekrar eden elemanı ilgili değişkene atıyoruz
            }
            //Bir eleman en çok tekrar eden elemanlı aynı sayıda tekrar ediyorsa iki elemandan en küçük olanı alınır
            else if (mikrotaryBird[i]==maxMikrotaryCounter && ourArray[i]<mikrotaryCounterValue)
                mikrotaryCounterValue=ourArray[i];
        }

        System.out.println(mikrotaryCounterValue);

    }

    public static int [] mikrotaryCounter(int [] ourArray)
    {
        int [] migrotaryBird=new int[ourArray.length];
        for (int i=0;i<ourArray.length;i++)
        {
            for(int j=0;j<ourArray.length;j++)
            {
                if (isFind(ourArray[i],ourArray,i))//İlgili metotta anlatılmıştır
                  continue;//İlgili metot sağlanıyorsa dizinin ilgili değişkeni es geçilir ve tekrar etme sayısı 0 atanır

                if (ourArray[i]==ourArray[j])
                    migrotaryBird[i]++;//dizideki ilgili indisdeki değer daha önce sayaca eklenmediysse ve yine tekrar edildiyse sayaç artar

            }
        }

        return migrotaryBird;
    }
    //Gelen elemanıın o ana kadar kontrol edilip edilmediği sağlanır
    public static boolean isFind(int value,int array[],int tempCounter)
    {
        for (int i=0;i<tempCounter;i++)
        {
            if (value==array[i])
                return true;
        }

        return false;
    }

}