package Location;

import Obstacle.*;
import Player.*;

import java.util.Scanner;

public class River extends BattleLoc
{
    Inventories inventory=new Inventories("Su");//Mekanın kendine özgü ekipmanı
    int obstacleQuality;
    Scanner input=new Scanner(System.in);
    public River( Player player)
    {
        super("Nehir", player, new Bear());
    }

    public void locationBehavior()//lokasyona davranışının 0lduğu metottur
    {

        System.out.println("Dikkat et Nehirde " + obstacle.getName() + " karşılaşabilirsin..  ");
        System.out.println("""
                Ne yapmak isterin:\s
                1-Savaş
                2-Kaç""");


        int choose = input.nextInt();
        while (choose < 0 || choose > 2) {
            System.out.println("Lütfen geçerli seçin yapınız: ");
            choose = input.nextInt();
        }
        switch (choose) {
            case 1 -> war();
            case 2 -> player.selectLocation();
        }

    }

    public void war()
    {
        int attackChoose = 0;// Savaştan kaçma seçeneği için iki döngüyüde kırması gerektiğinden buraya yazılmıştır
        obstacleQuality = random.nextInt(1, 4);  // Lokasyona her yeni gelişte random düşman türer


        while (getObstacleQuality() > 0)
        {
            obstacle.setHealty(obstacle.getStartHealty());  // tüm düşmanlar ölene dek ölen düşmandan sonrabir sonraki düşman için can hazırlanır
            System.out.println("Dikkat et burada " + getObstacleQuality() + " adet " + obstacle.getName() + " var");// Güncel düşman



            while (player.getHealty() > 0 || obstacle.getHealty() > 0)  // Oyuncu ölene veya düşman bitene kadar devam eder
            {

                if (priority() <= 9 && priority() > 7) // Random sayı belirtilen aralıktaysa canavar saldırır
                {
                    System.out.println(obstacle.getName() + " Size " + obstacle.getDemage() + " gücünde atak yaptı ");
                    player.setHealty(player.getHealty() - (obstacle.getDemage() - player.getInventories().getArmorDefence()));


                    if (player.getHealty() < 0)
                    {
                        player.setHealty(0); // Eğer olurda düşman vuruşu canımızı eksiye düşürüse can 0 atanır
                        System.out.println("Puslu diyarların koruyucusu öldü Allah bizi korusun..");
                        break;// oyuncu ölünce savaş biter
                    }


                    System.out.println("Kalan canınız: " + player.getHealty());


                }
                else if (priority() > 0 && priority() <= 5)// random sayı belirtilen aralıktaysa biz atak yaparız
                {
                    System.out.println("1-Vur" + "2-Kaç");
                    attackChoose = input.nextInt();

                    while (attackChoose < 1 || attackChoose > 2)
                    {
                        System.out.println("Lütfen geçerli bir işlem giriniz: ");
                        attackChoose = input.nextInt();
                    }
                    if (attackChoose == 1) {
                        System.out.println(obstacle.getName() + " üzerine saldırı düzenlediniz..");
                        obstacle.setHealty(obstacle.getHealty() - (player.getDemage() + player.getInventories().getWeaponDemage()));


                        if (obstacle.getHealty() <= 0) {
                            obstacle.setHealty(0);//Canavar canı 0'dan küçükse canavar canı 0 atanır
                        }

                        if (obstacle.getHealty() == 0) {
                            System.out.println("1 adet " + obstacle.getName() + " Öldürdünüz ");
                            --obstacleQuality;
                            setObstacleQuality(obstacleQuality);
                            System.out.println("Kalan " + obstacle.getName() + " sayısı: " + getObstacleQuality());
                            player.setMoney(player.getMoney()+6);
                            System.out.println("Güncel paranız: "+player.getMoney());
                            break;
                        }
                        if (obstacle.getHealty() > 0) {
                            System.out.println(obstacle.getName() + " kalan canı: " + obstacle.getHealty());
                        }
                    } else
                    {
                        player.selectLocation();
                        break;
                    }
                }
            }
            if (player.getHealty() <= 0) {
                System.out.println("Maalesef öldünüz..");
                break;
            }
            else if (attackChoose==2)
            {
                break;
            }
        }
        if (getObstacleQuality()==0)
        {
            System.out.println("Tebrikler tüm düşmanları öldürdünüz ");
            player.getInventories().setWater(true);
            System.out.println("Kazandığınız item: "+inventory.getInventoryOfLocationName());
        }


    }

    @Override
    public boolean onLocation() {
        locationBehavior();
        return true;
    }
    public int priority () {return random.nextInt(1, 10);}
    public int getObstacleQuality() {return this.obstacleQuality;}
    public void setObstacleQuality(int obstacleQuality) {this.obstacleQuality = obstacleQuality;}

}
