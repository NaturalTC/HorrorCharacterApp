package model;


import model.enums.Vulnerability;

/**
 * Class representing a Zombie character in the horror RPG game.
 * Zombies are vulnerable to fire and sunlight.
 */
public class Zombie extends HorrorCharacter {

    /**
     * Constructor for a Zombie character.
     * @param name name of the zombie
     * @param health health of the zombie
     * @param mana mana of the zombie
     */
    public Zombie(String name, int health) {
        super(name, health);

        // Zombies are vulnerable to fire and sunlight
        setVulnerabilities(new Vulnerability[] {
                Vulnerability.FIRE,
                Vulnerability.SUNLIGHT
        });
    }

    /**
     * Attack method for the zombie.
     * Zombies attack by eating the brains of their victims.
     */
    @Override
    public void attack(Player player) {
        System.out.println(getName() + " tries to escape but fell on his face!\n");
    }

    /**
     * Flee method for the zombie.
     * Zombies are unable to flee.
     */
    @Override
    public void flee() {
        System.out.println(getName() + " is unable to flee!\n");
    }

}
