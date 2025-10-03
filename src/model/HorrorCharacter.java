package model;

import model.enums.Vulnerability;

/**
 * Abstract base class for all horror characters.
 * Each character has a name, health, vulnerabilities, and mana.
 */
public abstract class HorrorCharacter {

    // Character attributes
    private String name;
    private int health;
    private int maxHealth;
    private Vulnerability[] vulnerabilities;

    /**
     * Constructor for a HorrorCharacter with health and optional mana.
     *
     * @param name   Name of the character.
     * @param health Initial health value.
     */
    public HorrorCharacter(String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.vulnerabilities = Vulnerability.values(); // default: all vulnerabilities
    }

    // ------------------------------------------------------------------------------
    // Abstract methods for HorrorCharacter(enemy) actions
    public abstract void attack(Player player);

    public abstract void flee();

    // ------------------------------------------------------------------------------
    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setVulnerabilities(Vulnerability[] vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Vulnerability[] getVulnerabilities() {
        return vulnerabilities;
    }

    // ------------------------------------------------------------------------------
    // Health management
    public void restoreHealth(int amount) {
        health = Math.min(maxHealth, health + amount);
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + health);
    }


}
