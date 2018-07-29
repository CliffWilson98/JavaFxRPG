import java.util.ArrayList;

public class MonsterHolder
{

    private static MonsterHolder instance = new MonsterHolder();

    private static ArrayList<GameCharacter> commonMonsterHolder;

    private static GameCharacter commonMonster1;

    private MonsterHolder()
    {
        commonMonsterHolder = new ArrayList<GameCharacter>();
        commonMonster1 = new GameCharacter("Orc Grunt", 125, WeaponsHolder.getRandomCommonWeapon(), 3, 1.2);
        commonMonsterHolder.add(commonMonster1);
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
