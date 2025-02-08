package Location;
import Obstacle.*;
import Player.*;
import java.util.Random;

//Savaş alanlarını temsil etmek için oluşturulmuştur
public abstract class BattleLoc extends Location
{
    Obstacle obstacle;//Her lokasyonun kendine özgü canavarı olacaktır
    Random random = new Random();

    public BattleLoc(String name, Player player, Obstacle obstacle)
    {
        super(name, player);
        this.obstacle = obstacle;
    }

    @Override
    abstract public boolean onLocation();



}