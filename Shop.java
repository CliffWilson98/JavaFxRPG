import javafx.scene.control.Label;

public class Shop
{
    private WeaponsHolder shopWeaponsHolder;
    private Weapon shopWeapon;

    private static Shop instance = new Shop();

    public static Shop getInstance()
    {
        return instance;
    }

    private Shop ()
    {
        shopWeaponsHolder = WeaponsHolder.getInstance();
        shopWeapon = shopWeaponsHolder.getRandomCommonWeapon();
    }

    public void updateShop()
    {
        shopWeapon = shopWeaponsHolder.getRandomCommonWeapon();
    }

    public void updateShopText(Label label)
    {
        String labelText = String.format("Welcome to the shop. Choose an item you would like to buy.\n" +
                "1. %1s\tAvg-Dmg: %d\tPrice: %d gold", shopWeapon.getName(), shopWeapon.getAverageDamage(), shopWeapon.getPrice());
        label.setText(labelText);
    }
}
