import java.util.Scanner;

public class ArrayActions
{
    static   Scanner input=new Scanner(System.in);

    /**Uniq array oluşturan metot**/
    public static int []  creeateAndControl()
    {

         System.out.println("Lütfen kaç elemanlı dizi gireceğinizi yazınız: ");
        int listLenght=input.nextInt();//Dizinin uzunluğu belirleniyor
        int [] list=new int[listLenght];// Uzunluk diziye atanıyor



        for (int index=0;index<list.length;index++)
        {
            System.out.println("Lütfen dizinin "+(index+1)+".elemanini giriniz: ");
            int tempElement=input.nextInt();//Geçici eleman oluşturulur
            if (index==0)// İlk eleman herhangi bir elemanla kontrol edilemez direkt diziye atanır
                list[index]=tempElement;

            /* Kontrol edilme kısmı ikinci elemandan belirlenir eğer index=1 ise artık girilen değer dizide bulunurmu diye kontrol edilir */
            else
            {
                for (int controlIndex = 0; controlIndex <index; controlIndex++)
                {
                    if (tempElement == list[controlIndex])/*Geçici eleman dizinin başından başlayarak sonuna kadar kontrol eder şart sağlanırsa*/
                    {
                        System.out.println("Listede olmayan bir eleman giriniz: ");// Kullanıcıdan tekrar eleman ister
                        tempElement=input.nextInt();//Yeniden geçici eleman alınır
                        /*for döngüsünde artma işlemi olacağı için biz azaltıp for döngüsüne göndeririz böylece aynı index farklı sayı girilene kadar tekrar alınır*/
                        controlIndex--;
                    }
                    else
                        list[index]=tempElement;
                }
            }
        }
        return list;
    }



    public  static void printArray(int [] list)
    {
        for (int IndexOfPrintValue=0;IndexOfPrintValue<list.length;IndexOfPrintValue++)
            System.out.println("Listenin "+(IndexOfPrintValue+1)+".elemanı: "+list[IndexOfPrintValue]);

    }
}
