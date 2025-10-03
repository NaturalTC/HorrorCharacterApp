package model.attacks.werewolf;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class HowlAttack implements AttackBehavior {
    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        boolean success = new Random().nextBoolean(); // 50% chance to intimidate
        if (success) {
            System.out.println(attacker.getName() + " howls, intimidating " + target.getName() + "! They skip their next turn.");
            target.setStunned(true); // assume Player has a stunned flag
        } else {
            System.out.println(attacker.getName() + " howls, but " + target.getName() + " resists the intimidation.");
        }
        return 0; // no damage
    }
}