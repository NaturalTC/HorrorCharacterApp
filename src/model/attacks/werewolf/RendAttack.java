package model.attacks.werewolf;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class RendAttack implements AttackBehavior {
    private final int minDamage = 12;
    private final int maxDamage = 20;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);

        // Werewolf gets a small heal from ripping flesh
        int heal = damage / 4;
        attacker.restoreHealth(heal);

        System.out.println(attacker.getName() + " rends " + target.getName() + ", dealing " + damage
                + " damage and healing " + heal + " HP.");
        return damage;
    }
}