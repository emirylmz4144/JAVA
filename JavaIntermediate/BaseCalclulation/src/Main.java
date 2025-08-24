import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Lütfen taban değerini giriniz: ");
        int under=input.nextInt();
        System.out.print("Lütfen üs değerini giriniz: ");
        int top=input.nextInt();
        System.out.println("Sonucunuz: "+baseCalculation(under,top));

    }

    public static int baseCalculation(int under,int top)
    {
        int result=1;
        if (top==0) //üs değeri 0 ise sonuc her zaman 1'dir
            return 1;
        for (int i=1;i<=top;i++)
            result*=under;

        return result;
    }
}