import java.util.ArrayList;

//Class which holds every monster in the game. The different monster tiers can be accessed
//from different getter methods.
public class MonsterHolder
{

    private static MonsterHolder instance = new MonsterHolder();

    private static ArrayList<GameCharacter> commonMonsterHolder;

    private static GameCharacter commonMonster1;
    private static GameCharacter commonMonster2;

    private MonsterHolder()
    {
        commonMonsterHolder = new ArrayList<GameCharacter>();
        commonMonster1 = new GameCharacter("Orc Grunt", 125, WeaponsHolder.getRandomCommonWeapon(), 3, 1.2);
        commonMonsterHolder.add(commonMonster1);
        commonMonster2 = new GameCharacter("Troll Peon", 100, WeaponsHolder.getRandomCommonWeapon(), 4, 1.4);
        commonMonsterHolder.add(commonMonster2);
    }

    public static GameCharacter getRandomCommonMonster ()
    {
        int randomNumber = (int)(Math.random() * (commonMonsterHolder.size()));
        return commonMonsterHolder.get(randomNumber);
    }

    public static MonsterHolder getInstance()
    {
        return instance;
    }

}
