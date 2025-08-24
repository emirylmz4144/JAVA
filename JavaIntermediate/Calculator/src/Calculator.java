import java.util.Scanner;

public class Calculator
{
    static Scanner input=new Scanner(System.in);
    public int plus()
    {

        System.out.print("Lütfen kaç adet sayı gireceğinizi yazınız: ");
        int numberToEnter=input.nextInt();
        int result=0;
        for (int i=1;i<=numberToEnter;i++)
        {
            System.out.print(i+".Sayiniz: ");
            int newNumber=input.nextInt();
            result+=newNumber;
        }
        return result;
    }
    public int minus()
    {

        System.out.print("Lütfen kaç adet sayı gireceğinizi yazınız: ");
        int numberToEnter=input.nextInt();
        int result=0;
        for (int i=1;i<=numberToEnter;i++)
        {
            System.out.print(i+".Sayiniz: ");
            int newNumber=input.nextInt();
            if (i==1)
            {
                result=newNumber;
                continue;
            }
            result-=newNumber;
        }
        return result;
    }

         public int times()
     {

          System.out.print("Lütfen kaç adet sayı gireceğinizi yazınız: ");
          int numberToEnter=input.nextInt();
          int result=1,i=1;
          while (i<=numberToEnter)
          {
              System.out.print(i+".Sayiniz: ");
              int newNumber=input.nextInt();
              if (newNumber==0)
              {
                  System.out.println("Sonucunuz: "+newNumber);
                  break;
              }
              result*=newNumber;
              i++;
          }
          return result;
     }
   public double divided()
    {

        System.out.print("Kaç adet sayı gireceksiniz :");
        int numberToEnter = input.nextInt();
        double newNumber, result = 0.0;

        for (int i =1; i <=numberToEnter;i++)
        {
            System.out.print(i + ".Sayiniz: ");
            newNumber = input.nextDouble();
            if (i!=1 &&
                    newNumber==0)
            {
                System.out.println("Böleni 0 giremezsiniz.");
                continue;
            }
            if (i == 1)
            {
                result = newNumber;
                continue;
            }
            result /= newNumber;
        }

        return  result;
    }

    public double power()
    {

        System.out.print("Kaç adet sayı gireceksiniz :");
        int numberToEnter = input.nextInt();
        double result=0,temperature = 0;
        for (int i=1;i<=(numberToEnter);i++)
        {

            System.out.print(i+".Sayiniz: ");
            int newNuber=input.nextInt();
            if (numberToEnter==1)
            {
                System.out.println("Lütfen en az iki sayi giriniz..");
                return newNuber;
            }
            if (i==1)
                temperature=newNuber;

            if ( i==2)
                result=Math.pow(temperature,newNuber);

            if (i>=3)
                result=Math.pow(result,newNuber);

        }
        return result;
    }

    public double square()
    {
        Scanner input=new Scanner(System.in);
        int result,valueToSquare;
        System.out.println("""
                Gireceginiz sayilara nasıl bir işlem yapacaksiniz:\s
                1-Hepsini toplayıp karekökünü alacağım
                2-hepsini çikarip karekökünü alacağım
                3-bir sayi girip onun karekökünü alacağım""");
        int choose=input.nextInt();
        if (choose==1 || choose==2)
        {
            if (choose==1)
                result=plus();
            else
                result=minus();

        }
        else
        {
            System.out.println("Lütfen karekökünü almak istediğiniz  sayiyi giriniz: ");
            valueToSquare=input.nextInt();
            result=valueToSquare;
        }
        return Math.sqrt(result);

    }

    public int factorial()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayı giriniz :");
        int n = scan.nextInt();
        int result = 1;

        for (int i = 1; i <= n; i++)
            result *= i;

        return result;
    }

}
