package model.attacks.zombie;

import interfaces.AttackBehavior;
import model.HorrorCharacter;
import model.Player;

import java.util.Random;

public class TripAttack implements AttackBehavior {
    @Override
    public int attack(Player target, HorrorCharacter attacker) {
        boolean success = new Random().nextBoolean(); // 50% chance to trip
        if (success) {
            System.out.println(attacker.getName() + " trips " + target.getName() + "! They skip their next turn.");
            target.setStunned(true); // assume Player has a stunned flag
        } else {
            System.out.println(attacker.getName() + " fails to trip " + target.getName() + ".");
        }
        return 0; // no damage
    }
}