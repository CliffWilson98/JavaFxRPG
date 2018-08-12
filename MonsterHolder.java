import java.lang.reflect.Array;
import java.util.ArrayList;

//Class which holds every monster in the game. The different monster tiers can be accessed
//from different getter methods.
public class MonsterHolder
{

    private static MonsterHolder instance = new MonsterHolder();
    private WeaponsHolder weaponsHolder = WeaponsHolder.getInstance();

    private ArrayList<GameCharacter> commonMonsterHolder;
    private ArrayList<GameCharacter> uncommonMonsterHolder;
    private ArrayList<GameCharacter> goodMonsterHolder;

    private GameCharacter commonMonster1;
    private  GameCharacter commonMonster2;
    private GameCharacter commonMonster3;
    private GameCharacter commonMonster4;
    private GameCharacter commonMonster5;

    private GameCharacter uncommonMonster1;
    private GameCharacter uncommonMonster2;
    private GameCharacter uncommonMonster3;
    private GameCharacter uncommonMonster4;
    private GameCharacter uncommonMonster5;

    private GameCharacter goodMonster1;
    private GameCharacter goodMonster2;
    private GameCharacter goodMonster3;
    private GameCharacter goodMonster4;
    private GameCharacter goodMonster5;

    private MonsterHolder()
    {
        commonMonsterHolder = new ArrayList<GameCharacter>();
        commonMonster1 = new GameCharacter("Orc Grunt", 8, weaponsHolder.getRandomCommonWeapon(), 3, 1.2, 3);
        commonMonsterHolder.add(commonMonster1);
        commonMonster2 = new GameCharacter("Troll Peon", 12, weaponsHolder.getRandomCommonWeapon(), 4, .8, 3);
        commonMonsterHolder.add(commonMonster2);
        commonMonster3 = new GameCharacter("Amateur Thief", 15, weaponsHolder.getRandomCommonWeapon(), 8, 1.4, 5);
        commonMonsterHolder.add(commonMonster3);
        commonMonster4 = new GameCharacter("Feral Bat", 10, weaponsHolder.getRandomCommonWeapon(), 5, 1, 4);
        commonMonsterHolder.add(commonMonster4);
        commonMonster5 = new GameCharacter("Undead Gravedigger", 12, weaponsHolder.getRandomCommonWeapon(), 6, 1.5, 6);
        commonMonsterHolder.add(commonMonster5);

        uncommonMonsterHolder =  new ArrayList<GameCharacter>();
        uncommonMonster1 = new GameCharacter("Orc Chief", 40, weaponsHolder.getRandomUncommonWeapon(), 20, 3, 20);
        uncommonMonsterHolder.add(uncommonMonster1);
        uncommonMonster2 = new GameCharacter("Troll Solider", 50, weaponsHolder.getRandomUncommonWeapon(), 24, 2.4, 22);
        uncommonMonsterHolder.add(uncommonMonster2);

        goodMonsterHolder = new ArrayList<GameCharacter>();
        goodMonster1 = new GameCharacter("Orc Captain" , 400, weaponsHolder.getRandomGoodWeapon(), 87, 4, 80);
        goodMonsterHolder.add(goodMonster1);

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

    public ArrayList<GameCharacter> getUncommonMonsterHolder()
    {
        return uncommonMonsterHolder;
    }

    public ArrayList<GameCharacter> getGoodMonsterHolder()
    {
        return goodMonsterHolder;
    }
}
