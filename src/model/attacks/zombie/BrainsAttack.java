package model.attacks.zombie;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class BrainsAttack implements AttackBehavior {
    private final int minDamage = 10;
    private final int maxDamage = 18;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " bites for brains! " + target.getName() + " takes " + damage + " damage!");
        return damage;
    }
}