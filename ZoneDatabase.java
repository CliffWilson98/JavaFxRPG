import java.util.ArrayList;

public class ZoneDatabase
{
    private Zone startingZone;
    private Zone mediumZone;
    private Zone hardZone;
    private ArrayList<Zone> gameZones;

    private static ZoneDatabase instance = new ZoneDatabase();

    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();
    private MonsterHolder monsterHolder = MonsterHolder.getInstance();

    private ZoneDatabase()
    {
        gameZones = new ArrayList<Zone>();
        startingZone = new Zone("Starting Zone", weaponsHolder.getCommonWeaponsHolder(), monsterHolder.getCommonMonsterHolder());
        gameZones.add(startingZone);

    }

    public Zone getStartingZone()
    {
        return gameZones.get(0);
    }

    public static ZoneDatabase getInstance()
    {
        return instance;
    }
}
