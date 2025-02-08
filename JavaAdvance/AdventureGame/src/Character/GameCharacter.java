package Character;

public abstract class  GameCharacter
{
    private int ID;
    private String name;
    private int healthy;
    private int money;
    private int demage;

    public GameCharacter(int ID,String name, int healthy, int money, int demage) {
        this.ID=ID;
        this.name = name;
        this.healthy = healthy;
        this.money = money;
        this.demage = demage;
    }

    /**Karakter bilgilerini yazdırır**/
    public static void characterInformations()
    {
        GameCharacter [] characters= {new Samurai(),new Archer(),new Knight(),new Legion()};
        for (GameCharacter character:characters)
        {
            System.out.println("--------------Karakter Bilgileri-----------------\n" +
                    "Karakter ID: "+character.getID()+"\n"+
                    "Karakter: "+character.getName()+"\n" +
                    "Sağlık: "+character.getHealthy()+"\n" +
                    "Para: "+character.getMoney()+"\n" +
                    "Hasar:"+character.getDemage());
        }
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }


}
