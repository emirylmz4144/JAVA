import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        List arrayList=Arrays.asList(
                new Kisi("emir","yılmaz",21, Kisi.ARABADURUMU.VAR),
                new Kisi("bilal","yılmaz",24, Kisi.ARABADURUMU.YOK),
                new Kisi("Hilal","yilmaz",26, Kisi.ARABADURUMU.VAR));

        //Anonymous class kullanarak functional interface yardımıyla filtreleme
        /*kisileriFiltrele(arrayList, new KisiFiltreleme() {
            @Override
            public boolean filtrele(Kisi kisi) {
            // Filtreleme ilgili sınıfın age özelliğine göre yapılmış
                return kisi.getName().contains("i")&&kisi.getAge()>21;
            }
        });
         */

        // Lambda Expressions kullanarak functional interface yardımı ile filtreleme
        kisileriFiltrele(arrayList,k->k.getName().contains("e"));//filreleme name property'sinin 'e' harfi içerme durumuna göre yapılmış
        System.out.println("------------------------------");
        kisileriFiltrele(arrayList,k-> k.getArabadurumu().equals(Kisi.ARABADURUMU.VAR));

    }

    /**
     * Filtrelenecek liste ve filtrelemenin sınıfın hangi özelliğine ait
     * propery'ye göre yapılacağının bilgisini alır**/
    public static void kisileriFiltrele(List<Kisi> kisiler,KisiFiltreleme filtreleme)
    {

        for (int i=0;i<kisiler.size();i++)
        {
            if (filtreleme.filtrele(kisiler.get(i)))
                System.out.println(kisiler.get(i));
        }
    }
}