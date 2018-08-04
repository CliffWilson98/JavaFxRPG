import java.util.ArrayList;

//Class which holds every weapon in the game. Identical in concept to the MonsterHolder class
public class WeaponsHolder
{
    private static WeaponsHolder instance = new WeaponsHolder();

    private static ArrayList<Weapon> commonWeaponsHolder;

    private static Weapon commonWeapon1;
    private static Weapon commonWeapon2;
    private static Weapon commonWeapon3;
    private static Weapon commonWeapon4;

    private WeaponsHolder()
    {
        commonWeaponsHolder = new ArrayList<Weapon>();
        commonWeapon1 = new Weapon("Common Hammer", 0, 3, 4);
        commonWeaponsHolder.add(commonWeapon1);
        commonWeapon2 = new Weapon("Common Sword", 0, 2, 4);
        commonWeaponsHolder.add(commonWeapon2);
        commonWeapon3 = new Weapon("Common Cestus", 1, 2, 4);
        commonWeaponsHolder.add(commonWeapon3);
        commonWeapon4 = new Weapon("Common Longsword", 2, 5, 8);

    }

    public static WeaponsHolder getInstance ()
    {
        return instance;
    }

    public static Weapon getRandomCommonWeapon ()
    {
        int randomNumber = (int)(Math.random() * (commonWeaponsHolder.size()));
        return commonWeaponsHolder.get(randomNumber);
    }


}
