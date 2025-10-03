import model.*;
import interfaces.Transformable;
import java.util.*;

public class HorrorCharacterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // === Character Selection ===
        System.out.println("Welcome to the Horror RPG!");
        System.out.println("Whats your name?");

        String nameInput = scanner.nextLine();

        Player player = new Player(nameInput, 100, 50);

        System.out.println("\nWelcome, " + player + "! You enter the dungeon...\n");

        // === Dungeon Loop ===
        int rooms = 5; // number of rooms
        for (int room = 1; room <= rooms && player.getHealth() > 0; room++) {
            System.out.println("=== Room " + room + " ===");

            int event = random.nextInt(4); // 0..3 event type
            switch (event) {
                case 0 -> { // Enemy encounter
                    System.out.println("An enemy appears!");
                    System.out.println("What do you want to do?");
                    System.out.println("1. Attack");
                    System.out.println("2. Transform (if possible)");
                    System.out.println("3. Flee");

                    int action = scanner.nextInt();
                    switch (action) {
                        case 1 -> player.attack();
                        case 2 -> {
                            if (player instanceof Transformable t) {
                                t.transform();
                            } else {
                                System.out.println(player.getName() + " cannot transform.");
                            }
                        }
                        case 3 -> player.flee();
                        default -> System.out.println("You freeze and take damage!");
                    }

                    // Enemy counterattack
                    int damage = random.nextInt(20) + 5; // 5–25 damage
                    player.setHealth(player.getHealth() - damage);
                    System.out.println("Enemy hits back! You take " + damage + " damage.");
                }
                case 1 -> { // Trap
                    int trapDamage = random.nextInt(15) + 5;
                    player.setHealth(player.getHealth() - trapDamage);
                    System.out.println("You triggered a trap! -" + trapDamage + " HP.");
                }
                case 2 -> { // Rest
                    int heal = random.nextInt(20) + 10;
                    player.setHealth(player.getHealth() + heal);
                    System.out.println("You found a safe spot. +" + heal + " HP restored.");
                }
                case 3 -> System.out.println("The room is empty. Nothing happens.");
            }

            // Show status
            System.out.println("Current HP: " + player.getHealth() + "\n");

            // Check defeat
            if (player.getHealth() <= 0) {
                System.out.println(player.getName() + " has perished in the dungeon...");
                break;
            }
        }

        if (player.getHealth() > 0) {
            System.out.println("Congratulations! You cleared the dungeon!");
        }

        scanner.close();
    }
}
