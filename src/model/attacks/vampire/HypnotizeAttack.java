package model.attacks.vampire;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

// ---------------------
// Hypnotize Attack
// ---------------------
public class HypnotizeAttack implements AttackBehavior {

    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        boolean success = new Random().nextBoolean(); // 50% chance
        if (success) {
            System.out.println(attacker.getName() + " hypnotizes " + target.getName() + "! They skip their next turn.");
            target.setStunned(true); // assume Player has a hypnotized flag
        } else {
            System.out.println(attacker.getName() + " fails to hypnotize " + target.getName() + ".");
        }
        return 0; // no damage
    }
}

