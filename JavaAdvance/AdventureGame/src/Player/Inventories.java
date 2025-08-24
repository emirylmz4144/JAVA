package Player;

public class Inventories
{
    private String inventoryOfLocationName;
    private boolean water;
    private boolean food;
    private boolean fireWood;
    private String weaponName;
    private String armorName;
    private int weaponDemage;
    private int armorDefence;
    public Inventories(String inventoryOfLocation)
    {
        this.inventoryOfLocationName =inventoryOfLocation;
    }

    public boolean isWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }


    public boolean isFireWood() {
        return this.fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDemage() {
        return weaponDemage;
    }

    public void setWeaponDemage(int weaponDemage) {
        this.weaponDemage = weaponDemage;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }


    public String getInventoryOfLocationName() {
        return inventoryOfLocationName;
    }
}
