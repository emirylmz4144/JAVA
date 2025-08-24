import java.util.HashMap;

public class Telephone extends Product {

    //Oluşacak her ürün ID değerine göre haritalandırılacak
   public static HashMap<Integer, Product> ourTelephones =new HashMap<>();


    public Telephone(String name, Brand brandOfPruduct, double screenSize, double battaryPower, int memory, int ram, String color, int price, int quality, int discountRate) {
        super(name, brandOfPruduct, screenSize, battaryPower, memory, ram, color, price, quality, discountRate);

        ourTelephones.put(this.getId(),this);
    }
}

