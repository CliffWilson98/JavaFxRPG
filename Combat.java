import javafx.scene.Scene;
import javafx.stage.Stage;

public class Combat
{
    //Creating private constructor for this class
    private Combat (){}

    private static Combat instance = new Combat();

    public static Combat getInstance()
    {
        return instance;
    }
    //Private helper methods to be ran in the combatManager()
    private  void attack (Player player, GameCharacter monster)
    {
        int monsterDamage = calculateDamage(monster);
        int playerDamage = calculateDamage(player);
        System.out.println("Player Damage " + playerDamage);
        System.out.println("Monster Damage " + monsterDamage);
        monster.takeDamage((playerDamage));
        if (monster.getCurrentHealth() > 0)
        {
            player.takeDamage(monsterDamage);
        }

    }

    private  <T extends GameCharacter> int calculateDamage(T character)
    {
        Weapon weapon = character.getWeapon();
        double damage = character.getDamageMultiplier() * weapon.getMaximumDamage();
        int randomDamage = (int)(Math.random() * damage);
        if (randomDamage < weapon.getMinimumDamage())
        {
            randomDamage = weapon.getMinimumDamage();
        }
        return randomDamage;
    }

    private  void heal (Player player, GameCharacter monster)
    {
        int monsterDamage = calculateDamage(monster);
        player.takeDamage(monsterDamage - player.getHealAmount());
        if (player.getCurrentHealth() > player.getMaxhealth())
        {
            player.setCurrentHealth(player.getMaxhealth());
        }
    }

    private  void castSpell(Player player, GameCharacter monster)
    {
        monster.takeDamage(player.getMagicDamage());
        player.setCurrentMana(player.getCurrentMana() - 1);
        if (monster.getCurrentHealth() > 0)
        {
            int monsterDamage = calculateDamage(monster);
            player.takeDamage(monsterDamage);
        }
    }

    private  String createCombatSummary(Player player, GameCharacter monster)
    {
        String combatSummary;

        if (player.getCurrentHealth() <= 0)
        {
            combatSummary = "You have perished in this combat encounter.";
        }
        else if (player.getCurrentHealth() > 0 && monster.getCurrentHealth() > 0)
        {
            combatSummary = String.format("You have fled the scene. No experience or gold is rewarded.");
        }
        else
        {
            combatSummary = String.format("You have killed the %s\nYou receive %d gold and %d XP", monster.getName(), monster.getGold(), monster.getXp());
        }

        return combatSummary;
    }

    //Primary method for combat. It invokes all necessary helper methods to manage the combat scenario.
    public  void combatManager (Player player, GameCharacter monster, AttackType type, Game game, Stage stage, Scene scene)
    {
        boolean combatIsOver = false;

        if(type == AttackType.ATTACK)
        {
            attack(player, monster);
        }
        else if(type == AttackType.HEAL)
        {
            heal(player, monster);
        }
        else if(player.getCurrentMana() > 0 && type == AttackType.MAGIC)
        {
            castSpell(player, monster);
        }
        else if (type == AttackType.ATTACK.FLEE)
        {
            combatIsOver = true;
        }
        game.updateCombatSceneText();

        if (player.getCurrentHealth() <= 0 || monster.getCurrentHealth() <= 0 || combatIsOver == true)
        {

            if (monster.getCurrentHealth() <= 0)
            {
                player.setGold(player.getGold() + monster.getGold());
                player.giveXp(monster.getXp());
                player.checkForLevelUp();
            }

            game.updatePostCombatSceneText(createCombatSummary(player, monster));
            regeneratePlayer(player);
            monster.setCurrentHealth(monster.getMaxhealth());
            stage.setScene(scene);
        }
    }

    private void regeneratePlayer(Player player)
    {
        player.setCurrentHealth(player.getMaxhealth());
        player.setCurrentMana(player.getMaxMana());
    }


}
