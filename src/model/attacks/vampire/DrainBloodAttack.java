package model.attacks.vampire;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

// ---------------------
// Drain Blood Attack
// ---------------------
public class DrainBloodAttack implements AttackBehavior {
    private final int minDamage = 5;
    private final int maxDamage = 12;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);

        // Vampire heals for half the damage dealt
        int heal = damage / 2;
        attacker.restoreHealth(heal);

        System.out.println(attacker.getName() + " drains blood from " + target.getName() + ", dealing "
                + damage + " damage and healing " + heal + " HP.");
        return damage;
    }
}
