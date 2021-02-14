//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.MagicCompass;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagicCompass implements Listener {
    private PhantasyGateManager plugin;

    public MagicCompass(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void click(PlayerInteractEvent e) {
        if ((new ItemSubFunctions()).IsThere(e.getPlayer(), this.item(), 0)) {
            if (e.getPlayer().getBedSpawnLocation() == null) {
                e.getPlayer().sendMessage("§cベッドが存在しません");
            } else {
                e.getPlayer().teleport(e.getPlayer().getBedSpawnLocation());
                e.getPlayer().spawnParticle(Particle.CLOUD, 1.0D, 3.0D, 1.0D, 1000);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1.0F, 1.0F);
            }
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§b§l魔法のコンパス");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックでリスポーン地点に戻るよ!");
        lore.add("§cベッドでスポーン位置を固定してね");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
