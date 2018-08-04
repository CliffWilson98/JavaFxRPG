//More specialized class to model the player. Extends the GameCharacter class
public class Player extends GameCharacter
{

    private int statPoints;
    private int healAmount;
    private int xpToNextLevel;
    private int level;
    private int magicDamage;
    private int maxMana;
    private int currentMana;

    public Player (String name, int maxHealth, Weapon weapon)
    {
        super(name, maxHealth, weapon, 0, 3, 0);
        statPoints = 5;
        healAmount = 3;
        xpToNextLevel = 10;
        level = 1;
        magicDamage = 3;
        maxMana = 1;
        currentMana = 1;
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
            setCurrentHealth(getMaxhealth());

        }
        else if (upgradeType == UpgradeType.DAMAGE)
        {
            upgradeDamage();
        }
        else if (upgradeType == upgradeType.MANA)
        {
            upgradeMana();
            setCurrentMana(getMaxMana());
        }
        else if (upgradeType == upgradeType.MAGIC)
        {
            upgradeMagic();
        }
        statPoints --;
    }

    private void upgradeHealth()
    {
        setMaxhealth(getMaxhealth() + (getLevel() * 2));
    }

    private void upgradeDamage()
    {
        setDamageMultiplier(getDamageMultiplier() + (getLevel()/10.0));
    }

    private void upgradeMana()
    {
        setMaxMana(getMaxMana() + 1);
    }

    private void upgradeMagic()
    {
        setMagicDamage(getMagicDamage() + (getLevel() *2) );
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
        level ++;
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

    public void giveXp(int xp)
    {
        setXp(getXp() + xp);
    }

    public int getXpToNextLevel()
    {
        return xpToNextLevel;
    }

    public int getLevel()
    {
        return level;
    }

    public int getMagicDamage()
    {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage)
    {
        this.magicDamage = magicDamage;
    }

    public int getMaxMana()
    {
        return maxMana;
    }

    public void setMaxMana(int mana)
    {
        this.maxMana = mana;
    }

    public int getCurrentMana()
    {
        return currentMana;
    }

    public void setCurrentMana(int currentMana)
    {
        this.currentMana = currentMana;
    }
}
