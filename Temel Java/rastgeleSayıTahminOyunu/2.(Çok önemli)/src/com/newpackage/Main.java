

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input=new Scanner(System.in);
    //Oyun deneme hakkı ve tahmini diziye atayacak sayaç tanımlanıyor
    static int trying=4,counter=0;
    //Doğru tahmin yapılırsa oyunu bitirecek değişken atanıyor
    static boolean isTheGameGoingToStop=false;
    static Random createRandomValue=new Random();
    static int []thinks=new int[5];//tahminleri bir dizide tutuyoruz
    static int number= createRandomValue.nextInt(1,50);

    public static void main(String[] args) {
        game();
        isWin();
        printScreenToThinks();

    }

    public static void game()
    {
        while (trying>=0 && !isTheGameGoingToStop)
        {
            System.out.println("Lütfen bir 1-50 arasında bir sayi giriniz: ");
            int think= input.nextInt();
            if (think<=0 || think>=50)
            {
                System.out.println("Belirtilen aralıkta değer girmediğiniz için can hakkınız azaldı kalan hakkınız "+trying--);
                continue;
            }
            //tahmini diziye atıyoruz
            thinks[counter++]=think;
            if (think==number)
                isTheGameGoingToStop=true;
            else
            {
                System.out.println("Yanlis cevap tekrar dene kalan can hakkınız:  "+trying);
                trying--;
            }
        }
    }
    public static void isWin()
    {
        //eğer şart doğruysa oyun kazanılmıştır
        if (isTheGameGoingToStop)
            System.out.println("Kazandınız:)) kalan can hakkınız: "+trying);

        else
            System.out.println("maalesef kaybettiniz:((");
    }
    public static void printScreenToThinks()
    {
        for (int m:thinks)
        {
            if (m!=0)
                System.out.print(m+" ");
        }
    }
}
