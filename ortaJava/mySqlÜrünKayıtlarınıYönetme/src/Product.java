public class Product
{
    private String name;
    private int price;
    private int stockAmount;

    Product(String name,int price,int stockAmount)
    {
        this.name=name;
        this.price=price;
        this.stockAmount=stockAmount;
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

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
