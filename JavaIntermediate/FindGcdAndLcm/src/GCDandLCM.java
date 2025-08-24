import java.util.Scanner;

public class GCDandLCM
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("1.sayıyı giriniz:  ");
        int sayi1 = input.nextInt();
        System.out.println("2.sayıyı giriniz:  ");
        int sayi2 = input.nextInt();
        int buyuk;
        int kucuk;
        if (sayi1 > sayi2) {
            buyuk = sayi1;
            kucuk = sayi2;
        } else {
            buyuk = sayi2;
            kucuk = sayi1;
        }

        for(int i = kucuk; 1 < i; --i) {
            if (buyuk % i == 0 && kucuk % i == 0) {
                System.out.println("" + i + " EN BÜYÜK ORTAK BÖLENDİR");
                break;
            }
        }

        for(int j = 1; j <= buyuk * kucuk; ++j) {
            if (j % buyuk == 0 && j % kucuk == 0) {
                System.out.println("" + j + " EN KÜÇÜK ORTAK KATTIR");
                break;
            }
        }
    }
}