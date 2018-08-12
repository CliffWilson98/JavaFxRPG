import java.sql.Array;
import java.util.ArrayList;

//Class which holds every weapon in the game. Identical in concept to the MonsterHolder class
public class WeaponsHolder
{
    private static WeaponsHolder instance = new WeaponsHolder();

    private  ArrayList<Weapon> commonWeaponsHolder;

    private  Weapon commonWeapon1;
    private  Weapon commonWeapon2;
    private  Weapon commonWeapon3;
    private  Weapon commonWeapon4;
    private  Weapon commonWeapon5;

    private  ArrayList<Weapon> uncommonWeaponsHolder;

    private  Weapon uncommonWeapon1;
    private  Weapon uncommonWeapon2;
    private  Weapon uncommonWeapon3;
    private  Weapon uncommonWeapon4;
    private  Weapon uncommonWeapon5;

    private ArrayList<Weapon> goodWeaponsHolder;

    private Weapon goodWeapon1;
    private Weapon goodWeapon2;
    private Weapon goodWeapon3;
    private Weapon goodWeapon4;
    private Weapon goodWeapon5;

    private WeaponsHolder()
    {
        commonWeaponsHolder = new ArrayList<Weapon>();
        commonWeapon1 = new Weapon("Common Hammer", 0, 3, 4);
        commonWeaponsHolder.add(commonWeapon1);
        commonWeapon2 = new Weapon("Common Sword", 0, 2, 4);
        commonWeaponsHolder.add(commonWeapon2);
        commonWeapon3 = new Weapon("Common Cestus", 1, 2, 4);
        commonWeaponsHolder.add(commonWeapon3);
        commonWeapon4 = new Weapon("Common Longsword", 0, 4, 10);
        commonWeaponsHolder.add(commonWeapon4);
        commonWeapon5 = new Weapon("Common Spear", 0, 4, 10);
        commonWeaponsHolder.add(commonWeapon5);

        uncommonWeaponsHolder = new ArrayList<Weapon>();
        uncommonWeapon1 = new Weapon("Uncommon Hammer", 4, 8, 65);
        uncommonWeaponsHolder.add(uncommonWeapon1);
        uncommonWeapon2 = new Weapon("Uncommon Sword", 4, 9, 65);
        uncommonWeaponsHolder.add(uncommonWeapon2);
        uncommonWeapon3 = new Weapon("Uncommon Spear", 5, 10, 70);
        uncommonWeaponsHolder.add(uncommonWeapon3);
        uncommonWeapon4 = new Weapon("Uncommon Cestus", 3, 11, 65);
        uncommonWeaponsHolder.add(uncommonWeapon4);
        uncommonWeapon5 = new Weapon("Lloyd's Mallet", 7, 13, 125 );
        uncommonWeaponsHolder.add(uncommonWeapon5);

        goodWeaponsHolder = new ArrayList<Weapon>();
        goodWeapon1 = new Weapon("Arthur's Hammer", 20, 30, 600);
        goodWeaponsHolder.add(goodWeapon1);
        goodWeapon2 = new Weapon("Vladimir's Spear", 22, 29, 595);
        goodWeaponsHolder.add(goodWeapon2);
        goodWeapon3 = new Weapon("Gregor's Greatsword", 30, 50, 1000);
        goodWeaponsHolder.add(goodWeapon3);
    }

    public static WeaponsHolder getInstance()
    {
        return instance;
    }

    public Weapon getRandomCommonWeapon()
    {
        int randomNumber = (int)(Math.random() * (commonWeaponsHolder.size()));
        return commonWeaponsHolder.get(randomNumber);
    }

    public Weapon getStartingWeapon()
    {
        return commonWeapon2;
    }

    public Weapon getRandomUncommonWeapon()
    {
        int randomNumber = (int)(Math.random() * (uncommonWeaponsHolder.size()));
        return uncommonWeaponsHolder.get(randomNumber);
    }

    public ArrayList<Weapon> getCommonWeaponsHolder()
    {
        return commonWeaponsHolder;
    }

    public ArrayList<Weapon> getUncommonWeaponsHolder()
    {
        return uncommonWeaponsHolder;
    }

    public ArrayList<Weapon> getGoodWeaponsHolder()
    {
        return goodWeaponsHolder;
    }

    public Weapon getRandomGoodWeapon()
    {
        int randomNumber = (int)(Math.random() * (goodWeaponsHolder.size()));
        return goodWeaponsHolder.get(randomNumber);
    }
}
