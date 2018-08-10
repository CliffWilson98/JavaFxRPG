import javafx.scene.control.Label;

public class Shop
{
    private Zone currentZone;
    private Weapon shopWeapon1;
    private Weapon shopWeapon2;

    private static Shop instance = new Shop();

    public static Shop getInstance()
    {
        return instance;
    }

    private Shop ()
    {
        updateShop();
    }

    public void updateShop()
    {
        currentZone = Game.getCurrentZone();
        shopWeapon1 = currentZone.getRandomWeapon();
        shopWeapon2 = currentZone.getRandomWeapon();
        while (shopWeapon2 == shopWeapon1)
        {
            shopWeapon2 = currentZone.getRandomWeapon();
        }
    }

    public void updateShopText(Label label)
    {
        String labelText = String.format("Welcome to the shop. Choose an item you would like to buy.\n" +
                "1. %1s\tAvg-Dmg: %d\tPrice: %d gold\n2. %1s\tAvg-Dmg: %d\tPrice: %d gold",
                shopWeapon1.getName(), shopWeapon1.getAverageDamage(), shopWeapon1.getPrice(), shopWeapon2.getName(), shopWeapon2.getAverageDamage(), shopWeapon2.getPrice());
        label.setText(labelText);
    }

    public void purchaseManager(Player player, int itemNumber)
    {
        Weapon purchasedWeapon = getItem(itemNumber);

        if (player.getGold() >= purchasedWeapon.getPrice())
        {
            player.setWeapon(purchasedWeapon);
            player.setGold(player.getGold() - purchasedWeapon.getPrice());
        }
    }

    private Weapon getItem (int itemNumber)
    {
        if (itemNumber == 1)
        {
            return shopWeapon1;
        }
        else
        {
            return shopWeapon2;
        }

    }
}
