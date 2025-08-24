import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // tanımlamalar ve üçgen genişliği alınır

        Scanner input=new Scanner(System.in);
        System.out.println("Lütfen oluşacak üçgenin genişliğini yazınız");
        int widht=input.nextInt();

        //oluşacak üçgen için döngü oluşturulur

        for(int i=widht;i>=1;i-=1)//Bu döngü bir sayaç gibidir boşlukların ve yıldızların tam oluşması için kullanılır
        {
            for(int j=1;j<=widht-i;j+=1)//ters üçgen olduğu için önce boşlular oluşturulur ve oluşacak boşluk miktarı belirlenir
                System.out.print(" ");
            for(int j=1;j<=i;j+=1)// Oluşacak üçgen için kaç yıldız gerektiği hesaplanır
                System.out.print("* ");

            System.out.println();/* dikkat edilmesi gereken kısım burasıdır üçgen bloğu oluştuktan sonra alt satıra geçilir */
        }
    }
}