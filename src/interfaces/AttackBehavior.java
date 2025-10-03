package interfaces;

import model.HorrorCharacter;
import model.Player;

public interface AttackBehavior {
    int attack(Player player, HorrorCharacter enemy);
}
