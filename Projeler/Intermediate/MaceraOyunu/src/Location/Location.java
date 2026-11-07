package Location;

import Player.*;

public abstract class Location {
    Player player;//Oyuncu lokasyonna geleceği için oyuncu nesnesi burada oluşturulur
    private String name;
    Location(String name,Player player)
    {
        this.name=name;
        this.player=player;

    }
   abstract public boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
