package Location;
import Player.*;

public class SafeHouse extends NormalLoc
{
    public SafeHouse(Player player)
    {
        super("Güvenli Ev", player);
    }
    /**Oyuncunun canının yenilenmesi sağlanır**/
    @Override
    public boolean onLocation()
    {
        System.out.println("Şu an "+getName()+" konumundasınız..");
        player.setHealty(player.getStartHealty());
        System.out.println("Canınız yenilendi güncel canınız: "+player.getHealty());
        return true;
    }


}
