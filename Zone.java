import java.util.ArrayList;

public class Zone
{
    private String name;
    private ArrayList<Weapon> zoneWeapons;
    private ArrayList<GameCharacter> zoneMonsters;

    public Zone(String name, ArrayList<Weapon> zoneWeapons, ArrayList<GameCharacter> zoneMonsters)
    {
        this.name = name;
        this.zoneWeapons = zoneWeapons;
        this.zoneMonsters = zoneMonsters;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Weapon> getZoneWeapons()
    {
        return zoneWeapons;
    }

    public void setZoneWeapons(ArrayList<Weapon> zoneWeapons)
    {
        this.zoneWeapons = zoneWeapons;
    }

    public ArrayList<GameCharacter> getZoneMonsters()
    {
        return zoneMonsters;
    }

    public void setZoneMonsters(ArrayList<GameCharacter> zoneMonsters)
    {
        this.zoneMonsters = zoneMonsters;
    }

    public GameCharacter getRandomEnemy()
    {
        int randomNumber = (int)(Math.random() * (zoneMonsters.size()));
        return zoneMonsters.get(randomNumber);
    }

    public Weapon getRandomWeapon()
    {
        int randomNumber = (int)(Math.random() * (zoneWeapons.size()));
        return zoneWeapons.get(randomNumber);
    }
}
