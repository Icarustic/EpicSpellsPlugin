package epicspellsplugin.spells;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class WindBlast extends BaseSpell {

    public WindBlast() {
        super("WindBlast", "Blow your enemies away with a gust of wind!");
    }

    @Override
    public void cast(Player player, int power) {
        Vector direction = player.getLocation().getDirection();
        direction.multiply(2.0 * power); // The strength of the wind can be adjusted by the power level
        direction.setY(1); // Add a little lift to the wind effect

        player.getWorld().getEntitiesByClass(Player.class).stream()
            .filter(p -> p != player && p.getLocation().distance(player.getLocation()) < 10) // Affects players within 10 blocks
            .forEach(p -> p.setVelocity(p.getVelocity().add(direction)));

        // Add any additional effects here, like particles or sounds
    }
}
