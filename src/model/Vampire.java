package model;

import interfaces.AttackBehavior;
import interfaces.Transformable;
import model.attacks.vampire.BiteAttack;
import model.attacks.vampire.DrainBloodAttack;
import model.attacks.vampire.HypnotizeAttack;
import model.enums.Vulnerability;

import java.util.ArrayList;
import java.util.Random;

public class Vampire extends HorrorCharacter implements Transformable {

    // State to track transformation
    private boolean transformed = false;
    private final ArrayList<AttackBehavior> attacks = new ArrayList<>();
    private final Random random = new Random();

    public Vampire(String name, int health) {
        super(name, health);

        attacks.add(new BiteAttack());
        attacks.add(new DrainBloodAttack());
        attacks.add(new HypnotizeAttack());

        // Vampires are vulnerable to sunlight and holy water
        setVulnerabilities(new Vulnerability[]{
                Vulnerability.SUNLIGHT,
                Vulnerability.HOLY_WATER
        });
    }

    @Override
    public void attack(Player target) {
        // Pick a random attack
        AttackBehavior chosenAttack = attacks.get(random.nextInt(attacks.size()));
        int damage = chosenAttack.attack(target, this);
        if (damage > 0) {
            System.out.println(getName() + " deals " + damage + " damage to " + target.getName() + "!\n");
        }
    }


    @Override
    public void flee() {
        System.out.println(getName() + " tries to escape but fell on his face!\n");
    }


    @Override
    public void transform() {
        if (getHealth() <= 0) {
            System.out.println(getName() + " you are dead! You cannot transform.\n");
        } else if (transformed) {
            System.out.println(getName() + " is transformed back into a vampire!\n");
            setName(getName().replace("Bat-", ""));
            setHealth(getHealth() + 10);
            transformed = false;
        } else {
            System.out.println(getName() + " transforms into a bat!\n");
            setName("Bat-" + getName());
            setHealth(getHealth() - 10);
            transformed = true;
        }
    }
}
