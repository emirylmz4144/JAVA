import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;//Kullanıcı adını ve şifresini doğru girmesi için 3 hak tanınır
        int balance = 0;

        while (right > 0 ) {
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals("emiryilmaz4144") && password.equals("emiryilmaz1234"))
            {
                System.out.println("Merhaba, Beymir Bankasına Hoşgeldiniz!");
                do
                {
                    System.out.println("""
                            1-Para yatırma
                            2-Para Çekme
                            3-Bakiye Sorgula
                            4-Çıkış Yap""");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    int choose = input.nextInt();
                    if (choose == 1)
                    {
                        System.out.print("Para miktarı : ");
                        int price = input.nextInt();
                        balance += price;
                    }
                    else if (choose == 2)
                    {
                        System.out.print("Para miktarı : ");
                        int price = input.nextInt();
                        if (price > balance)
                            System.out.println("Bakiye yetersiz.");
                        else
                            balance -= price;
                    }
                    else if (choose == 3)
                        System.out.println("Bakiyeniz : " + balance);

                    else if (choose>=5)
                        System.out.println("Hatali tuşmala yaptiniz\nBaşka işlem yapmak için aşağıdaki numaralardan birini seçiniz\nistemiyorsanız çıkış yapınız..");
                }

                while (select != 4);


                System.out.println("Tekrar görüşmek üzere...");
                break;


            }
            else
            {
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                if (right == 0)
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                 else
                    System.out.println("Kalan Hakkınız : " + right);
            }
        }
    }

}