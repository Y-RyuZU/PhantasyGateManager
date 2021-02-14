//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.basis;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.ItemStack;

public class UnabaleGoHell implements Listener {
    private PhantasyGateManager plugin;

    public UnabaleGoHell(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Gate(PlayerPortalEvent e) {
        e.getPlayer().sendMessage("§4§l地獄§cにはまだ行けません。アップデート近日公開予定");
        e.setCancelled(true);
    }

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void spawn(CreatureSpawnEvent e) {
        if (e.getEntity().getLocation().getBlock().getType() == Material.WATER) {
            e.setCancelled(true);
        }

    }
}
