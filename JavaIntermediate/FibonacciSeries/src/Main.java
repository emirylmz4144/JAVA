import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner user=new Scanner(System.in);

        System.out.print("Lütfen fibonnacci serisinin uzunluğunu giriniz: ");
        int userFibonnacciLenght=user.nextInt();

        System.out.print("Lütfen fibonnacci serisinde aramak istediğiniz elemani giriniz ");
        int userFibonnacciValue=user.nextInt();

        howelement(userFibonnacciLenght,userFibonnacciValue);
       /*  fibonacci uzunluğu ve aranmak istenen eleman
        ilgili fonksiyona gönderilir */


    }


    public static void howelement(int elmntNmbr,int value)// Fibonacci serisi oluşturulur
    {
        int [] fibonnacciLenght=new int[elmntNmbr];
        int element1=1,element2=1; // ilk 2 eleman 1 dir
        fibonnacciLenght[0]=element1;// ilgili sıraya eleman eklenir
        fibonnacciLenght[1]=element2;// ilgili sıraya eleman eklenir

        for (int i=0;i<elmntNmbr-2;i++)//uzunluk ilk 2 elemanın üzerine eklediği için 2 çıkarılmıştır
            fibonnacciLenght[i+2]=fibonnacciLenght[i]+fibonnacciLenght[i+1];

        check(fibonnacciLenght,value);// kontrol için solid prensipleri açısından yeni bir fonksiyona gönderilinir
    }



    public static void check(int[] fibonnacciLenght, int value)
    {
        int count=0;
        for (int checking=0;checking<fibonnacciLenght.length;checking++)//aranan eleman burada bulunmaya çalışılır
        {

            if (fibonnacciLenght[checking]==value)//kontrol değeri aranan elemana eşitse koşul sağlanır
            {
                System.out.println("Aradığınız eleman listenin "+(checking+1)+" sırasındadır");
                break;
            }

            count++;//eğer eleman bulunmadıysa sayaç artar
            if (count==fibonnacciLenght.length)//sayaç liste uzunluğuna geldiği halde eleman bulunmadıysa öyle bir eleman yoktur
            {
                System.out.println("Aradığınız eleman listede yoktur");
            }
        }
        System.out.println(Arrays.toString(fibonnacciLenght));// fibonacci serisi ekrana yazdırılır
    }

}
