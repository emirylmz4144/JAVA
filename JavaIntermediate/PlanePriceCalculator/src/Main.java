import java.util.Scanner;

public class Main {
    static Scanner input=new Scanner(System.in);
    static  int count=3; //Herhangi bir bilgide 3 kere format dışı tuşlama veya hata olursa program kapanır

    static boolean status=true;
    public static void main(String[] args)
    {
        while (status)//Programın 3 hatadan sonra kapanınca hata mesajı vermesi için döngüye koymak gerekir
        {

            System.out.println("Lütfen gideceğiniz uçuşun mesafesini KM cinsinden yazarmısınız");

            double distance=controlDistance(input.nextDouble());
            if (!status)break;//Eğer format 3 kere yanlış girilirse döngüden çıkarak hata mesajı verir
            double tempPrice=distance*(4.39);// Mesafeye göre indirimsiz fiyat belirlenmiştir

            System.out.println("""
                Yolculuk tipiniz nasıl olacak?:
                1-Sadece gidiş bileti alacağım
                2-Gidiş dönüş bileti alacağım""");

            int choose=controlTravelType(input.nextInt());
            if (!status) break;//Eğer format 3 kere yanlış girilirse döngüden çıkarak hata mesajı verir

            System.out.println("Lütfen yaşınızı giriniz:");
            int age=controlAge(input.nextInt());

            if (!status)break;//Eğer format 3 kere yanlış girilirse döngüden çıkarak hata mesajı verir
            double price= PriceCalculation(age,tempPrice,choose);
            String formattedPrice = String.format("%.2f", price);
            System.out.print("ÖDEYECEĞİNİZ TUTAR--> "+formattedPrice+" TL");
            break;

        }

        if (count<0)
            System.out.println("Birden fazla kere hatalı değer girerek programı kandırmaya çalıştınız");
    }

    public static double controlDistance(double distance)
    {
        while (distance<=0)
        {
            if (count>0)
            {
                count--;
                System.out.println("Lütfen uçuş mesafesini doğru bir mesafe olarak giriniz");
                distance=input.nextDouble();
            }
            else
            {
                status=false;
                break;
            }
        }
        return distance;
    }
    public static int controlTravelType(int choose)
    {
        while (choose<1 || choose>2 )
        {
            if (count>0)
            {
                count--;
                System.out.println("Lütfen yolculuk tipinizi seçenekler arasından seçiniz..");
                System.out.println("1-Sadece gidiş bileti alaağım\n" +
                        "2-Gidiş dönüş bileti alacağım");
                choose=input.nextInt();//while yerine if else olsaydı hatalı tuşlamada program kapanacaktı
            }
            else
            {
                status=false;
                break;
            }
        }
        return choose;
    }

    public static int controlAge(int age)
    {
        while (age<0 || age>140) {
            if (count>0)
            {
                count--;
                System.out.println("Lütfen geçerli bir yaş giriniz ");
                age=input.nextInt();
            }
            else
            {
                status=false;
                break;
            }
        }
        return age;
    }
    static double PriceCalculation(int age,double price,int choose) //indirim işlemleri için gerekli parametreler göderildi
    {
        price=ageDiscount(price,age);
        price=travelTypeDiscount(price,choose);
        return price;
    }
    public static double ageDiscount(double price,int age)
    {
        if (age<12)
            price=price-(price*(0.2));
        else if (age<24)
            price=price-(price*(0.1));
        else if(age>65)
            price=price-(price-(price*(0.3)));

        return price;
    }
    public static double travelTypeDiscount(double price,int choose)
    {
        if(choose == 2)
            price=2*(price-price*(0.2));
        return price;
    }
}