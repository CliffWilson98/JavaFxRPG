//Class to model the player and all enemies.
public class GameCharacter
{

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int gold;
    private double damageMultiplier;
    private Weapon weapon;


    public GameCharacter(String name, int maxHealth, Weapon weapon, int gold, double damageMultiplier)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
		this.weapon = weapon;
		this.damageMultiplier = damageMultiplier;
		this.gold = gold;
    }

    public String getName ()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMaxhealth()
    {
        return maxHealth;
    }

    public void setMaxhealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth)
    {
        this.currentHealth = currentHealth;
    }

    public double getDamageMultiplier()
    {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier)
    {
        this.damageMultiplier = damageMultiplier;
    }

    public void setWeapon (Weapon weapon)
    {
        this.weapon = weapon;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public void takeDamage(int damage)
    {
        currentHealth -= damage;
    }

}
