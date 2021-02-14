//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.OnJoinPlayer;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinPlayer implements Listener {
    private PhantasyGateManager plugin;

    public JoinPlayer(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    private void Message(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("");
        p.sendMessage("§e§l§m========================");
        p.sendMessage("");
        p.sendMessage("§e" + p.getName() + "さん §bログインありがとう!");
        p.sendMessage("§a困ったら /pgm");
        p.sendMessage("§7/pgm -> SHOP で資材が売れるよ! CASINOでスロットも回せるよ!");
        p.sendMessage("§7サバイバルワールドで生活をしよう!");
        p.sendMessage("");
        p.sendMessage("§e§l§m========================");
        p.sendMessage("");
        if (p.hasPlayedBefore()) {
            e.setJoinMessage("§f§l>§f " + p.getName() + "§eがログインしました");
        } else {
            e.setJoinMessage("§f§l>§f " + p.getName() + "§eが初めてログインしました!");
            Bukkit.broadcastMessage("§6みんなに§a§lお初チケット§6が配布されます!");
            Iterator var3 = Bukkit.getOnlinePlayers().iterator();

            while(var3.hasNext()) {
                Player player = (Player)var3.next();
                ItemStack item = new ItemStack(Material.PAPER);
                ItemMeta itemMeta = item.getItemMeta();
                List<String> lore = new ArrayList();
                lore.add("§eロビーのガチャで回せます");
                itemMeta.setLore(lore);
                itemMeta.setDisplayName("§6§lお初 - §e§lTicket");
                item.setItemMeta(itemMeta);
                player.getInventory().addItem(new ItemStack[]{item});
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            }

            Double x = this.plugin.config.getConfig().getDouble("config.firstspawn.x");
            Double y = this.plugin.config.getConfig().getDouble("config.firstspawn.y");
            Double z = this.plugin.config.getConfig().getDouble("config.firstspawn.z");
            World w = Bukkit.getWorld(this.plugin.config.getConfig().getString("config.firstspawn.w"));
            p.setBedSpawnLocation(new Location(w, x, y, z));
        }

    }

    @EventHandler
    private void move(PlayerMoveEvent e) {
        if (e.getPlayer().getWorld().getName().equals("world")) {
            Double x = this.plugin.config.getConfig().getDouble("config.firstspawn.x");
            Double y = this.plugin.config.getConfig().getDouble("config.firstspawn.y");
            Double z = this.plugin.config.getConfig().getDouble("config.firstspawn.z");
            World w = Bukkit.getWorld(this.plugin.config.getConfig().getString("config.firstspawn.w"));
            e.getPlayer().teleport(new Location(w, x, y, z));
        }

    }

    public void SetFirstSpawn(Player p) {
        this.plugin.config.getConfig().set("config.firstspawn.x", p.getLocation().getX());
        this.plugin.config.getConfig().set("config.firstspawn.y", p.getLocation().getY());
        this.plugin.config.getConfig().set("config.firstspawn.z", p.getLocation().getZ());
        this.plugin.config.getConfig().set("config.firstspawn.w", p.getLocation().getWorld().getName());
        this.plugin.config.saveConfig();
        p.sendMessage(this.plugin.logo + "§e初期スポーン地点を設定しました!");
    }
}
