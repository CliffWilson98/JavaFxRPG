//More specialized class to model the player. Extends the GameCharacter class
public class Player extends GameCharacter
{

    private int statPoints;
    private int healAmount;
    private int xpToNextLevel;

    public Player (String name, int maxHealth, Weapon weapon)
    {
        super(name, maxHealth, weapon, 0, 3, 0);
        statPoints = 5;
        healAmount = 10;
        xpToNextLevel = 10;
    }

    public String toString ()
    {
        String toString;
        toString = String.format("Name: %s", super.getName());
        System.out.println(toString);
        return toString;
    }

    public int getStatPoints ()
    {
        return statPoints;
    }

    public void setStatPoints (int statPoints)
    {
        this.statPoints = statPoints;
    }


    public void upgradeManager(UpgradeType upgradeType)
    {
        if (upgradeType == UpgradeType.HEALTH)
        {
            upgradeHealth();
        }
        else if (upgradeType == UpgradeType.DAMAGE)
        {
            upgradeDamage();
        }
        statPoints --;
    }

    private void upgradeHealth()
    {
        setMaxhealth(getMaxhealth() + 25);
    }

    private void upgradeDamage()
    {
        setDamageMultiplier(getDamageMultiplier() + .2);
    }

    public void setHealAmount(int healAmount)
    {
        this.healAmount = healAmount;
    }

    public int getHealAmount()
    {
        return healAmount;
    }

    private void levelUp()
    {
        statPoints ++;
        setXp(getXp()-xpToNextLevel);
        xpToNextLevel += 5;
    }

    public void checkForLevelUp()
    {
        if (getXp() > xpToNextLevel)
        {
            levelUp();
        }
    }
}
