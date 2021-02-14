//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.OnJoinPlayer;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeavePlayer implements Listener {
    private PhantasyGateManager plugin;

    public LeavePlayer(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void leave(PlayerQuitEvent e) {
        e.setQuitMessage((String)null);
    }
}
