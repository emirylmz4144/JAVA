package Address;

import Account.*;

import java.util.Scanner;
import java.util.function.Function;

public class AddressMenager
{
   static Scanner input=new Scanner(System.in);
    public static void addAddress(User user)
    {
        Address address;
        System.out.print("Lütfen şehir giriniz: "); String city=input.nextLine();
        System.out.print("Lütfen ilçe  giriniz: "); String town=input.nextLine();
        System.out.print("Lütfen mahalle giriniz: "); String neighborhood=input.nextLine();
        System.out.print("Lütfen sokak giriniz: "); String street=input.nextLine();
        System.out.print("Lütfen bina adı/ Şirket adı giriniz: "); String buildOrCompanyName=input.nextLine();
        System.out.print("Lütfen kapı numarası/ şirket bina numarası giriniz: "); int doorOrComplexNumber=input.nextInt();

        System.out.println("Girdiğiniz adresin ev adresi olduğunu doğrulamak için (1) iş adresi olduğunu doğrulamak için (2) tuşlayın"); int choose=input.nextInt();
        while (choose<1 || choose>2)
        {
            System.out.println("Lütfen geçerli bir seçim yapınız "); choose=input.nextInt();
        }
        if (choose==1)
             address=new HomeAddress(city,town,neighborhood,street,buildOrCompanyName,doorOrComplexNumber);
        else
            address=new BusinessAddress(city,town,neighborhood,street,buildOrCompanyName,doorOrComplexNumber);

        user.getUsersAddress().add(address);
    }

   public static void deleteAddress(User user)
    {
        
        System.out.print("Lütfen şehir giriniz: "); String city=input.nextLine();
        System.out.print("Lütfen ilçe  giriniz: "); String town=input.nextLine();
        System.out.print("Lütfen mahalle giriniz: "); String neighborhood=input.nextLine();
        System.out.print("Lütfen sokak giriniz: "); String street=input.nextLine();
        System.out.print("Lütfen bina adı/ Şirket adı giriniz: "); String buildOrCompanyName=input.nextLine();
        System.out.print("Lütfen kapı numarası/ şirket bina numarası giriniz: "); int doorOrComplexNumber=input.nextInt();
        String addresToDeleted=city+"/"+town+"/"+neighborhood+"/"+street+"/"+buildOrCompanyName+"/"+doorOrComplexNumber;
        
        if (user.getUsersAddress().stream().map(Object::toString).map(String::toUpperCase).anyMatch(addresToDeleted.toUpperCase()::equals))
        {
            for (int i=0;i<user.getUsersAddress().size();i++)
            {
                if (user.getUsersAddress().get(i).toString().toLowerCase().equals(addresToDeleted.toString().toLowerCase()))
                {
                    user.getUsersAddress().remove(user.getUsersAddress().get(i));
                    System.out.println("Adres başarı ile silindi..");
                }
            }
        }
        else
            System.out.println("Böyle bir adres bulunmamaktadır");


    }
}
