package Location;

import Equipmnet.*;
import Player.*;

import java.util.Scanner;


public class ToolStore extends NormalLoc
{
    Scanner input=new Scanner(System.in);

    public ToolStore(Player player)
    {
        super("Silah Mağazası", player);
    }

    @Override
    public boolean onLocation()
    {
          menu();
          return true;
    }
    public void menu()
    {

        System.out.println("""
                Lütfen Ne alacağınızı seçiniz:\s
                1-Silahlar
                2-Zırhlar
                3-Bilgileri Görüntüle
                0-Çıkış""");
        int choose=input.nextInt();
        while (choose<0|| choose>3)
        {
            System.out.println("Lütfen geçerli bir seçim yapınız: ");
            choose=input.nextInt();
        }
        switch (choose)
        {
            case 1:
                weaponInformations();
                buyWeapon();
                break;
            case 2:
                armorInformations();
                buyArmor();
                break;
            case 3:
                showPlayerInformations();
                break;
            case 0:
                player.selectLocation();
                break;

        }
    }
    public void showPlayerInformations()
    {
        System.out.println("Momey: "+player.getMoney());
        System.out.println("Healty: "+player.getHealty());

    }
    public  void weaponInformations()
    {
        Weapon[] weapons={new Pistol(),new Sword(),new Rifle(),new Stunner()};
        for (Weapon weapon:weapons)
        {
            System.out.println("-----------Silah Bilgileri-------------\n" +
                    "Silah ID: "+weapon.getID()+"\n" +
                    "Silah Adı: "+weapon.getName()+"\n" +
                    "Silah Hasarı: "+weapon.getDemage()+"\n" +
                    "Silah Fiyatı: "+weapon.getPrice());
        }
    }
    public  void armorInformations()
    {
        Armor [] armors={new Light(),new Medium(),new Heavy(),new Strong()};
        for (Armor armor:armors)
        {
            System.out.println("-----------Silah Bilgileri-------------\n" +
                    "Zırh ID: "+armor.getID()+"\n" +
                    "Zırh Adı: "+armor.getName()+"\n" +
                    "Zırh Düşman Bloklama: "+armor.getBlock()+"\n" +
                    "Zırh Fiyatı: "+armor.getPrice());
        }
    }

    public void buyWeapon()
    {
        Weapon weapon=null;
        System.out.println("Lütfen seçiminizi yapınız: ");
        int choose=input.nextInt();

        while (choose<0 || choose >4)
        {
            System.out.println("Lütfen geçerli bir seçin yapınız: ");
            choose=input.nextInt();
        }

        switch (choose)
        {
            case 1 :
                weapon = new Pistol();
                player.getInventories().setWeaponDemage(weapon.getDemage());
            break;

            case 2 :
                weapon = new Sword();
                player.getInventories().setWeaponDemage(weapon.getDemage());
            break;

            case 3 :
               weapon = new Rifle();
               player.getInventories().setWeaponDemage(weapon.getDemage());
            break;

             case 4 :
                weapon = new Stunner();
                player.getInventories().setWeaponDemage(weapon.getDemage());
             break;
        }


        if (player.getMoney()>=weapon.getPrice())
        {
            System.out.println("İşlem başarılı şu silah alındı: "+weapon.getName());



            System.out.println("Eski Bakiye: "+player.getMoney());
            player.setMoney(player.getMoney()-weapon.getPrice());
            System.out.println("Güncel bakiye: "+player.getMoney());

            System.out.println("Eski Hasar Gücü: "+player.getDemage());
            player.setDemage(player.getDemage()+weapon.getDemage());
            System.out.println("Güncel Hasar Gücü: "+ player.getDemage());
        }
        else
        {
            System.out.println("Bakiye yetersiz..");
            menu();
        }
    }

    public void buyArmor()
    {
        Armor armor=null;
        System.out.println("Lütfen seçiminizi yapınız: ");
        int choose=input.nextInt();

        while (choose<0 || choose >4)
        {
            System.out.println("Lütfen geçerli bir seçin yapınız: ");
            choose=input.nextInt();
        }

        switch (choose)
        {
            case 1 :
            {
                armor = new Light();
                player.getInventories().setArmorDefence(armor.getBlock());
            }
            break;
            case 2 :
            {
                armor = new Medium();
                player.getInventories().setArmorDefence(armor.getBlock());
            }
            break;
            case 3 :
            {
                armor = new Heavy();
                player.getInventories().setArmorDefence(armor.getBlock());
            }
            break;
            case 4 :
            {
                armor = new Strong();
                player.getInventories().setArmorDefence(armor.getBlock());
            }
            break;
        }


        if (player.getMoney()>=armor.getPrice())
        {
            System.out.println("İşlem başarılı şu silah alındı: "+armor.getName());
            System.out.println(armor.getName()+" ile canavarların vuruş gücü "+armor.getBlock()+"kadar azalacak");


            System.out.println("Eski Bakiye: "+player.getMoney());
            player.setMoney(player.getMoney()-armor.getPrice());
            System.out.println("Güncel bakiye: "+player.getMoney());
        }
        else
        {
            System.out.println("Bakiye yetersiz..");
            menu();
        }
    }

}
