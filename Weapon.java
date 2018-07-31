//Models an individual weapon. The weapon will be stored in the weapons holder class.
public class Weapon
{
	private int minimumDamage;
	private int maximumDamage;
	private String name;
	
	public Weapon (String name, int minimumDamage, int maximumDamage)
	{
		setName(name);
		setDamage(minimumDamage, maximumDamage);
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public void setDamage (int minimumDamage, int maximumDamage)
	{
		this.minimumDamage = minimumDamage;
		this.maximumDamage = maximumDamage;
	}

	public int getMaximumDamage ()
    {
        return maximumDamage;
    }

    public int getMinimumDamage ()
	{
		return minimumDamage;
	}
	
	public int getAverageDamage (){return (maximumDamage + minimumDamage)/2;}
	
}
