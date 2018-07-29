import java.util.ArrayList;

//MUST USE SINGLETON STRATEGY
public class WeaponsHolder
{
    private static WeaponsHolder instance = new WeaponsHolder();

    private static ArrayList<Weapon> commonWeaponsHolder;

    private static Weapon commonWeapon1;
    private static Weapon commonWeapon2;
    private static Weapon commonWeapon3;

    private WeaponsHolder()
    {
        commonWeaponsHolder = new ArrayList<Weapon>();
        commonWeapon1 = new Weapon("Common Hammer", 2, 5);
        commonWeaponsHolder.add(commonWeapon1);
        commonWeapon2 = new Weapon("Common Sword", 2, 4);
        commonWeaponsHolder.add(commonWeapon2);
        commonWeapon3 = new Weapon("Common Cestus", 1, 3);
        commonWeaponsHolder.add(commonWeapon3);

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
