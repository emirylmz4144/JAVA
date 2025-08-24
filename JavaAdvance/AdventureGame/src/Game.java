
import Player.*;

public class Game
{
  Player player=new Player();


     public void run()
     {


       System.out.println("Dünyanın karanlık ve korkunç bölgesine hoşgeldin..");
       player.selectChar();


           while (true)
               {
                   //Tüm ekipmanlar alınmamış ve oyuncu yaşıyorsa(yaşamıyorsa ihtimali o ihtimalin olduğu yerde oyunu sonlandırır) oyun devam eder
                   if (!player.getInventories().isFireWood() || !player.getInventories().isFood()|| !player.getInventories().isWater())
                   {
                       System.out.println(player.getInventories().isFood());
                       player.selectLocation();
                   }
                   //Oyuncu öldüyse oyun biter
                   else if (player.getHealty()<=0)
                       break;
                   //Oyuncu tüm ekipmanları elde ettiyse oyunu kazanır
                   else if (player.getInventories().isFireWood() || player.getInventories().isFood()|| player.getInventories().isWater())
                   {
                       System.out.println(
                               "Tebrikler şovalye tüm bu zorluklardan kurtulup" +
                               "Dünyamızı kurtardınız artık Dünyanın Şahısınız " +
                               "Yüce majesteleri "+player.getPlayerName()
                                         );
                       break;
                   }

               }
     }

}
