import javafx.scene.Scene;
import javafx.stage.Stage;

public class Combat
{
    //Creating private constructor for this class
    private Combat (){}

    //Private helper methods to be ran in the combatManager()
    private static void attack (Player player, GameCharacter monster)
    {
        int monsterDamage = (int)calculateDamage(monster);
        int playerDamage = (int)calculateDamage(player);
        System.out.println("Player Damage " + playerDamage);
        System.out.println("Monster Damage " + monsterDamage);
        monster.takeDamage((playerDamage));
        if (monster.getCurrentHealth() > 0)
        {
            player.takeDamage(monsterDamage);
        }

    }

    private static <T extends GameCharacter> double calculateDamage(T character)
    {
        Weapon weapon = character.getWeapon();
        double damage = character.getDamageMultiplier() * weapon.getAverageDamage();
        double randomDamage = (Math.random() * damage) + weapon.getMinimumDamage();
        return randomDamage;
    }

    private static void heal (Player player, GameCharacter monster)
    {
        int monsterDamage = (int)calculateDamage(monster);
        player.takeDamage(monsterDamage - player.getHealAmount());
    }

    private static String createCombatSummary(Player player, GameCharacter monster, Game game)
    {
        String combatSummary;

        if (player.getCurrentHealth() <= 0)
        {
            combatSummary = "You have perished in this combat encounter.";
        }
        else
        {
            combatSummary = String.format("You have killed the %s", monster.getName());
        }
        
        return combatSummary;
    }

    //Primary method for combat. It invokes all necessary helper methods to manage the combat scenario.
    public static void combatManager (Player player, GameCharacter monster, AttackType type, Game game, Stage stage, Scene scene)
    {
        if(type == AttackType.ATTACK)
        {
            attack(player, monster);
        }
        else if(type == AttackType.HEAL)
        {
            heal(player, monster);
        }
        game.updateCombatSceneText();

        if (player.getCurrentHealth() <= 0 || monster.getCurrentHealth() <= 0)
        {
            if (monster.getCurrentHealth() <= 0)
            {
                player.setGold(player.getGold() + monster.getGold());
            }

            player.setCurrentHealth(player.getMaxhealth());
            monster.setCurrentHealth(monster.getMaxhealth());
            stage.setScene(scene);
        }
    }


}
