import java.util.*;

public class Main
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Object> ourNewHashMap = new HashMap<>();

        ourNewHashMap.put(1, "Emir");
        ourNewHashMap.put(2, "Bilal");
        ourNewHashMap.put(3, "Hilal");
        ourNewHashMap.put(4, "Mecbure");
        ourNewHashMap.put(5, "Casim");
        ourNewHashMap.put(6, "Zeynep");
        ourNewHashMap.put(7, "Yaren");
        ourNewHashMap.put(8, "Yılmaz");



        for (Map.Entry<Integer,Object> objectEntry:ourNewHashMap.entrySet())
        {
            String value= (String) objectEntry.getValue();
            if (value.contains("a"))
            {
                System.out.println("Değer 'a' harfi içerdiğinden yazılamaz");
            }
            else
            {
                System.out.println("İsim: "+value);
            }
        }




    }
}