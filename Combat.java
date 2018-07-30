public class Combat
{
    //Creating private constructor for this class
    private Combat (){}


    private static void attack (Player player, GameCharacter monster)
    {
        int monsterDamage = (int)calculateDamage(monster);
        int playerDamage = (int)calculateDamage(monster);
        System.out.println("Player Damage " + playerDamage);
        System.out.println("Monster Damage " + monsterDamage);
        player.takeDamage(monsterDamage);
        monster.takeDamage((playerDamage));

    }

    private static <T extends GameCharacter> double calculateDamage(T character)
    {
        Weapon weapon = character.getWeapon();
        double damage = character.getDamageMultiplier() * (weapon.getMaximumDamage() - weapon.getMinimumDamage());
        double randomDamage = (Math.random() * damage) + weapon.getMinimumDamage();
        return randomDamage;
    }

    private static void heal (Player player, GameCharacter monster)
    {
        int monsterDamage = (int)calculateDamage(monster);
        player.takeDamage(monsterDamage - player.getHealAmount());
    }

    public static void combatManager (Player player, GameCharacter monster, AttackType type, Game game)
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
    }


}
