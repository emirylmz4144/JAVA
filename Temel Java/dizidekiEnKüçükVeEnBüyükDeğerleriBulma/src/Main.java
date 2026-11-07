import java.util.Scanner;


public class Main


{
    public static void minAndMax(int [] list)
    {
        int minimimValue=list[0],maximumValue=list[0];//min ve max değerlerine karşılaştırma yapmak için ilk değer ataması
        for (int comparisonValue:list)            // foreach ile karşılaştırma operatörü listedeki elemanlarla karşılaştırılır
        {
            if (minimimValue>comparisonValue)
                minimimValue=comparisonValue;// koşul doğruysa karşılaşrtırma operatörü en küçük değere atanır

            if (maximumValue<comparisonValue)
                maximumValue=comparisonValue;//  koşul doğruysa karşılaşrtırma operatörü en b değere atanır

        }
        System.out.println("Minimum değer "+minimimValue+"\nMaximum değer: "+maximumValue);
    }
    public static void main(String[] args)
    {

        Scanner input=new Scanner(System.in);
        System.out.println("Kaç elemanlı liste gireceksiniz?: ");
        int elementQuality=input.nextInt();
        int [] list=new int[elementQuality];
        System.out.println(list.length);

        // Diziye değer atamalarının kullanıcıdan alınmması

        for (int value=0;value<list.length;value++)
            System.out.println("Listenin "+(value+1)+".elemanini giriniz: "); list[value]=input.nextInt();

        minAndMax(list);// Burada fonksiyona liste atılır ve fonksiyonda değerler bulunur

    }
}