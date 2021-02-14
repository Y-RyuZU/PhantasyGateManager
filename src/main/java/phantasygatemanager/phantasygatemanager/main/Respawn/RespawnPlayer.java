//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.Respawn;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnPlayer implements Listener {
    private PhantasyGateManager plugin;

    public RespawnPlayer(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void respawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        e.setRespawnLocation(p.getBedSpawnLocation());
    }
}
