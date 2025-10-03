package model.attacks.werewolf;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class StrikeAttack implements AttackBehavior {
    private final int minDamage = 10;
    private final int maxDamage = 16;

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " strikes " + target.getName() + " for " + damage + " damage!");
        return damage;
    }
}