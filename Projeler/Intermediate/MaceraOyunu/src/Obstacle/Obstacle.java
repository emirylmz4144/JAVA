package Obstacle;

public abstract class Obstacle {
    private int ID;
    private int demage;
    private int healty;
    private int money;
    private String name;
    private int startHealty;




    public Obstacle(int ID,int demage,int healty,int money,String name) {
        this.ID=ID;
        this.demage=demage;
        this.healty=healty;
        this.money=money;
        this.name=name;
        this.startHealty=healty;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDemage() {
        return demage;
    }


    public int getMoney() {
        return money;
    }


    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getStartHealty() {return startHealty;}

    public void setStartHealty(int startHealty) {this.startHealty = startHealty;}
}
