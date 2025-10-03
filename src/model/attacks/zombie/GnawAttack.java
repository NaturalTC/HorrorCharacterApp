package model.attacks.zombie;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class GnawAttack implements AttackBehavior {
    private final int minDamage = 6;
    private final int maxDamage = 12;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " gnaws " + target.getName() + " for " + damage + " damage!");
        return damage;
    }
}