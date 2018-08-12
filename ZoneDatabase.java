import java.util.ArrayList;

public class ZoneDatabase
{
    private Zone startingZone;
    private Zone intermediateZone;
    private Zone hardZone;
    private ArrayList<Zone> gameZones;

    private static ZoneDatabase instance = new ZoneDatabase();

    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();
    private MonsterHolder monsterHolder = MonsterHolder.getInstance();

    private ZoneDatabase()
    {
        gameZones = new ArrayList<Zone>();
        startingZone = new Zone("Starting Zone", "You are in the starting zone.", weaponsHolder.getCommonWeaponsHolder(), monsterHolder.getCommonMonsterHolder());
        gameZones.add(startingZone);
        intermediateZone = new Zone("Intermediate Zone", "This zone is more challenging than the first", weaponsHolder.getUncommonWeaponsHolder(), monsterHolder.getUncommonMonsterHolder());
        gameZones.add(intermediateZone);
        hardZone = new Zone("Hard Zone", "This is a high level zone. You must be well equipped to adventure here.", weaponsHolder.getGoodWeaponsHolder(), monsterHolder.getGoodMonsterHolder());
        gameZones.add(hardZone);
    }

    public Zone getStartingZone()
    {
        return gameZones.get(0);
    }

    public Zone getIntermediateZone()
    {
        return gameZones.get(1);
    }

    public Zone getZoneAtIndex(int index)
    {
        if (gameZones.get(index) == null)
        {
            return gameZones.get(0);
        }
        else
        {
            return gameZones.get(index);
        }
    }

    public static ZoneDatabase getInstance()
    {
        return instance;
    }
}
