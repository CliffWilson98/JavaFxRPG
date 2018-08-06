import java.util.ArrayList;

//Class which holds every monster in the game. The different monster tiers can be accessed
//from different getter methods.
public class MonsterHolder
{

    private static MonsterHolder instance = new MonsterHolder();
    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();

    private ArrayList<GameCharacter> commonMonsterHolder;

    private GameCharacter commonMonster1;
    private  GameCharacter commonMonster2;

    private MonsterHolder()
    {
        commonMonsterHolder = new ArrayList<GameCharacter>();
        commonMonster1 = new GameCharacter("Orc Grunt", 8, weaponsHolder.getRandomCommonWeapon(), 3, 1.2, 3);
        commonMonsterHolder.add(commonMonster1);
        commonMonster2 = new GameCharacter("Troll Peon", 12, weaponsHolder.getRandomCommonWeapon(), 4, .8, 3);
        commonMonsterHolder.add(commonMonster2);
    }

    public GameCharacter getRandomCommonMonster ()
    {
        int randomNumber = (int)(Math.random() * (commonMonsterHolder.size()));
        return commonMonsterHolder.get(randomNumber);
    }

    public static MonsterHolder getInstance()
    {
        return instance;
    }

    public ArrayList<GameCharacter> getCommonMonsterHolder()
    {
        return commonMonsterHolder;
    }
}
