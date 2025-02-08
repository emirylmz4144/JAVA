import java.util.Random;

public class MatchArea
{
    Fighter fighter1;
    Fighter fighter2;
    int maxWeight;
    int minWeight;

    public MatchArea(Fighter fighter1, Fighter fighter2, int maxWeight, int minWeight) //Constuructor oluşturuldu
    {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }
    void run() // Maçı başlatmak için run metotu kullanıldı
    {

        if (weightControl()) //Siklet kontrolünden gelen değer ile maç başladı
        {
            //İki dövüşçüden birinin sağlığı negatig olana kadar dövüş devam eder.
            while (this.fighter1.healty>0 && this.fighter2.healty>0) {
                if (whoWin())
                    whoIsAttacker();
            }
        }
        else // Sikletler uymuyorsa maç başlamaz
            System.out.println("Sporcuların sikletleri uyuşmuyor..");
    }
    boolean weightControl() // Sporcuların max-min kilolarda olup olmadığı kontrol edilip siklet kontrolü yapılıyor
    {
        return ((this.fighter1.weight>=this.minWeight &&this.fighter1.weight<=maxWeight )&&(this.fighter2.weight>=minWeight && this.fighter2.weight<=this.maxWeight));
    }

    boolean whoWin() // Kimin kazandığını anlamak için oluşturulan metot
    {                //Hangi dövüşçü kazanırsa ona özel kazanma senaryosu oluşturuldu

        if (fighter1.healty==0 || fighter2.healty==0)//İki dövüşçüden birinin sağlığı 0 sa her zaman false döner
        {
            if (fighter2.healty == 0)
                winner(this.fighter1);
            else if (fighter1.healty == 0)
                winner(this.fighter2);

            return false;
        }
        return true;//İki dövüşçünün de sağlığı o değilse dövüş devam etsin diye true döner
    }
    void whoIsAttacker()
    {
        Random random=new Random();
        int whoIsAttacker=random.nextInt(0,3); //Kimin atak yapacağı belirlemek için random sayı üretildi
        if (whoIsAttacker==1) // Eğer dönen değer 1 ise fighter1 atak yapan kişi olacak
            attack(this.fighter1,this.fighter2);

        else if (whoIsAttacker==2) // Eğer dönen değer 2 ise fighter2 atak yapan kişi olacak
            attack(this.fighter2,this.fighter1);

    }

    public void attack(Fighter fighter1,Fighter fighter2)
    {
        fighter2.healty=fighter1.hit(fighter2);//Parametrede ilk gelen dövüşçü atağı yapan dövüşçüdür.
        if (fighter2.healty<=0) // Sağlığın eksi değere düşüp düşmediği kontrol edildi
            fighter2.healty=0; // sağlık eksi değer ise sağlığın 0 a eşitlenmesi

        System.out.println(fighter2.name+" Kalan gücü: "+fighter2.healty); // Atak yiyen dövüşçünün kalan sağlığı belirlendi
    }


       public void winner(Fighter fighter)
       {
           System.out.println("************************************************************");
           System.out.println(fighter.name+" MUHTEŞEM MÜCADELESİ İLE MAÇIN GA Lİ Bİİİİ..");
           System.out.println("************************************************************");
       }


}
