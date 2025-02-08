
/**
 * Metoda parametre olarak gelecek sınıfa ait özelliklerin
 * her birine ait filtreleme metodu yapmak yerine functional interface
 * ile sınıfa ait her özelliğe filtrelemeyi tek bir metot ile yapmak için
 * oluşturulan interface **/
@FunctionalInterface
public interface KisiFiltreleme
{
   public boolean filtrele(Kisi kisi);
}
