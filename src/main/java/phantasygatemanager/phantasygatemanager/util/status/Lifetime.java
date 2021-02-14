//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.util.status;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class Lifetime extends BukkitRunnable {
    private PhantasyGateManager plugin;

    public Lifetime(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void run() {
        Iterator var1 = Bukkit.getOnlinePlayers().iterator();

        while(var1.hasNext()) {
            Player p = (Player)var1.next();
            this.plugin.status.getConfig().set("status.lifetime." + p.getUniqueId(), this.plugin.status.getConfig().getInt("status.lifetime." + p.getUniqueId()) + 1);
        }

        this.plugin.status.saveConfig();
    }
}
