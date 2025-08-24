import java.util.Random;

public class Fighter
{
    String name;
    int demage;
    int healty;
    int weight;

    //Özellikler atanıyor
    public Fighter(String name, int demage, int healty, int weight)  //Constuructor oluşturuldu
    {
        this.name = name;
        this.demage = demage;
        this.healty = healty;
        this.weight = weight;
    }

    int hit(Fighter warriorToBeAttacked) // Dövüşçünün nesnesi dövüşçüye atak özelliği aktarsın diye hit metotuna gönderildi
    {
        System.out.println("============================================================");
        Random rand=new Random(); //
        int isWillBeDodge=rand.nextInt(0,10); // Savunma yapılıp yapılmaması için random sayı üretildi
          if (warriorToBeAttacked.healty>0)
            {
              System.out.println(this.name+" => "+warriorToBeAttacked.name+" ÜZERİNE "+this.demage+" GÜCÜNDE ATAK YAPTI ");
                if (isWillBeDodge<=6 ) //Eğer üretilen sayı 6 dan küçükse savunma yapılıyor
                  {
                     System.out.println(warriorToBeAttacked.name+" den inanilmaz bir savunma..");
                    return warriorToBeAttacked.healty-(this.demage-dodge()); // savunma yapılırsa atak alan kişinin can durumu
                  }
               }

         return warriorToBeAttacked.healty-this.demage; //Savunma yapılmazsa atak alan kişinin can durumu
    }

    int dodge() //Savunma gücünün ne kadar olduğunu belirlemek için oluşturulan metot
    {
        Random rand=new Random(); // Random savunma gücü belirleme
        return rand.nextInt(0, this.demage); // Savunma gücünü ilgili yere gönderme
    }

}
