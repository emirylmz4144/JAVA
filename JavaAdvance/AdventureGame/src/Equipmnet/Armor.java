package Equipmnet;

public abstract class Armor
{
   private int ID;
   private String name;
   private int block;
   private int price;

   //Savunma aletlerini temsil eder
    public Armor(int ID, String name, int block, int price) {
        this.ID = ID;
        this.name = name;
        this.block = block;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
