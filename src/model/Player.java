package model;

import interfaces.Transformable;
import model.enums.Vulnerability;

public class Player implements Transformable {

    private String name;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana;
    private Vulnerability[] vulnerabilities;

    /**
     * Constructor for a HorrorCharacter with health and optional mana.
     *
     * @param name   Name of the character.
     * @param health Initial health value.
     * @param mana   Initial mana value.
     */
    public Player(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.maxHealth = health;
        this.maxMana = mana;
        this.vulnerabilities = Vulnerability.values(); // default: all vulnerabilities

    }

    public void flee() {
        // Possible flee logic for a hero character
    }

    @Override
    public void transform() {
        // Possible transformation logic for a hero character based on level
    }

    // ------------------------------------------------------------------------------
    // Mana management
    public boolean useMana(int amount) {
        if (mana >= amount) {
            mana = mana - amount;
            return true;
        } else {
            System.out.println(name + " does not have enough mana!");
            return false;
        }
    }

    public void restoreMana(int amount) {
        mana = Math.min(maxMana, mana + amount);
    }

    // ------------------------------------------------------------------------------
    // Health management
    public int getHealth() {
        return this.health;
    }
    public int setHealth(int health) {
        return this.health = health;
    }
    public void restoreHealth(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    // ------------------------------------------------------------------------------
    // Damage handling
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + health);
    }

    public void attack() {
        // Possible attack logic for a hero character
    }

    public String getName() {
        return name;
    }

    public void setStunned(boolean b) {
        // Possible hypnotized state management
    }
}
