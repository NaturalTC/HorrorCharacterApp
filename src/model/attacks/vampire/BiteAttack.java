package model.attacks.vampire;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

// ---------------------
// Bite Attack
// ---------------------
public class BiteAttack implements AttackBehavior {
    private final int minDamage = 8;
    private final int maxDamage = 15;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " bites " + target.getName() + " for " + damage + " damage!");
        return damage;
    }
}
