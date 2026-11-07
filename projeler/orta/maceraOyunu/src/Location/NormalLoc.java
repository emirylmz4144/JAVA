package Location;

import Player.Player;

//Oyuncunun savaşmayacağı alanları temsil eden sınıf
public abstract class NormalLoc extends Location
{
    NormalLoc(String name, Player player)
    {
        super(name, player);
    }
    @Override
    public boolean onLocation()
    {
        return true;
    }

}
