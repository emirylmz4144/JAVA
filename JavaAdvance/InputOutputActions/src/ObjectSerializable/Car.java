package ObjectSerializable;

import java.io.Serializable;

public class Car implements Serializable
{
    private String name;
    private String brand;
    private int price;

    public Car() {
    }

    public Car(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
