//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.sword;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DrainAxe implements Listener {
    private PhantasyGateManager plugin;

    public DrainAxe(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void damaged(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.PLAYER) {
            Player p = (Player)e.getDamager();
            Entity entity = e.getEntity();
            if ((new ItemSubFunctions()).IsThere(p, this.item(), 0)) {
                double damage = e.getDamage();
                double hp = p.getHealth();
                if (hp + damage / 3.0D > 20.0D) {
                    hp = 20.0D;
                } else {
                    hp += damage / 3.0D;
                }

                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                p.setHealth(hp);
            }
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.WOOD_AXE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§a宿木の§7斧");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        List<String> lore = new ArrayList();
        lore.add("§a与えたダメージの33%を吸収");
        lore.add("§7とある地域で宿木は幸運を呼ぶとされている");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
