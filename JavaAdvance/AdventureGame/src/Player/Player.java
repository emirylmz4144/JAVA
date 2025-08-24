package Player;
import Character.*;
import Location.Location;

import java.util.Scanner;
import Location.*;

public class Player
{
   private String charName;
   private String playerName;
   private int demage;
   private int startDemage;
   private int healty;
   private int startHealty;

   private int money;
   private int startMoney;

   private Inventories inventories =new Inventories("null");//Tüm inventorler toplandığı zaman oyun kazanılacak
   Scanner input=new Scanner(System.in);




    public void selectChar()
    {
        System.out.println("Lütfen seçmek istediğiniz karakteri giriniz: ");
        GameCharacter.characterInformations();
        int choose=input.nextInt();
        while (choose<1 || choose>4)
        {
            System.out.println("Lütfen geçerli bir seçin yapınız: ");
            choose=input.nextInt();
        }
        System.out.println("Lütfen karakterinize ad veriniz: ");
        this.playerName=input.next();

        switch (choose) {
            case 1 -> initPlayer(new Samurai());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            case 4 -> initPlayer(new Legion());
        }

    }
    public void initPlayer(GameCharacter characterInformations)
    {
        setCharName(characterInformations.getName());

        setStartHealty(characterInformations.getHealthy());
        setHealty(characterInformations.getHealthy());

        setStartDemage(characterInformations.getDemage());
        setDemage(characterInformations.getDemage());

        setStartMoney(characterInformations.getMoney());
        setMoney(characterInformations.getMoney());

        System.out.println("Hoşgeldin karanlıkların savunucusu "+characterInformations.getName()+" "+getPlayerName());
    }


    public void selectLocation()
    {
        Location location = null;
        System.out.println("Bu puslu boşluktan çıkıp nereye gitmek istersin: ");
        System.out.println("""
                1-Güvenli Ev
                2-Mağaza
                3-Orman
                4-Mağara`
                5-Nehir
                """);
        int choose=input.nextInt();
        while (choose<1 || choose>5)
        {
            System.out.println("Lütfen geçerli bir seçim yapınız :");
            choose=input.nextInt();
        }
        switch (choose)
        {
            //this dediği bu sınıf yani oyuncudur
            case 1:
                location=new SafeHouse(this);
                break;
            case 2:
                location=new ToolStore(this);
                break;
            case 3:
                location=new Forest(this);
                break;
             case 4:
                location=new Cave(this);
                break;
            case 5:
                location=new River(this);
                break;
        }
        location.onLocation();//Gidilen lokasyona özgü olayların gerçekleştirildiği yer.
    }


    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventories getInventories() {
        return inventories;
    }

    public int getStartDemage() {
        return startDemage;
    }

    public void setStartDemage(int startDemage) {
        this.startDemage = startDemage;
    }

    public int getStartHealty() {
        return startHealty;
    }

    public void setStartHealty(int startHealty) {
        this.startHealty = startHealty;
    }

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }

    public void setInventories(Inventories inventories) {
        this.inventories = inventories;
    }
}
