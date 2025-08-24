import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Calculator calculator=new Calculator();
        Scanner scan = new Scanner(System.in);
        int select;
        String menu = """
                    1- Toplama İşlemi
                    2- Çıkarma İşlemi
                    3- Çarpma İşlemi
                    4- Bölme işlemi
                    5- Üslü Sayı Hesaplama
                    6- Karekök Alma İşlemi
                    7- Faktoriyel Hesaplama
                    0- Çıkış Yap""";
        do {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz :");
            select = scan.nextInt();
            switch (select)
            {
                case 1 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.plus());
                    System.out.println("********************************************");
                }
                case 2 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.minus());
                    System.out.println("********************************************");
                }
                case 3 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.times());
                    System.out.println("********************************************");
                }
                case 4 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.divided());
                    System.out.println("********************************************");
                }
                case 5 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.power());
                    System.out.println("********************************************");
                }
                case 6 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.square());
                    System.out.println("********************************************");
                }
                case 7 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Sonucunuz: " + calculator.factorial());
                    System.out.println("********************************************");
                }
                case 0 ->
                {
                    System.out.println("********************************************");
                    System.out.println("Çıkış yaptınız..");
                    System.out.println("********************************************");
                }
                default -> System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        }
        while (select != 0);
    }

}