public class Product
{

    //Notebook ve telefonlar ürün classından inheritence olacak
    private String name;
    private int price;
    private int discountRate;
    private int quality;
    private Brand brandOfPruduct;

    private double screenSize;

    private double battaryPower;

    private  int memory;
    private int ram;

    private String color;

    private static int nextId=1;
    private int id;

    public Product(String name, Brand brandOfPruduct, double screenSize, double battaryPower, int memory, int ram, String color, int price, int quality, int discountRate) {
        this.name = name;
        this.brandOfPruduct = brandOfPruduct;
        this.screenSize = screenSize;
        this.battaryPower = battaryPower;
        this.memory = memory;
        this.ram = ram;
        this.color = color;
        this.price = price;
        this.quality = quality;
        this.discountRate = discountRate;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Brand getBrandOfPruduct() {
        return brandOfPruduct;
    }

    public void setBrandOfPruduct(Brand brandOfPruduct) {
        this.brandOfPruduct = brandOfPruduct;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getBattaryPower() {
        return battaryPower;
    }

    public void setBattaryPower(double battaryPower) {
        this.battaryPower = battaryPower;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
