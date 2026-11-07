package Equipmnet;

public abstract class Weapon
{
    private int ID;
    private String name;
    private int demage;
    private int price;

    //Saldırı aletlerini temsil eder
    public Weapon(int ID, String name, int demage, int price) {
        this.ID = ID;
        this.name = name;
        this.demage = demage;
        this.price = price;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
