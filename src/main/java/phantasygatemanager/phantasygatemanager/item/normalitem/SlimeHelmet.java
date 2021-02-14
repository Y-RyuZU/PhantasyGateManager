//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.normalitem;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SlimeHelmet implements Listener {
    private PhantasyGateManager plugin;

    public SlimeHelmet(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void damaged(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            Player p = (Player)e.getEntity();
            if ((new ItemSubFunctions()).IsThere(p, this.item(), 2)) {
                if (e.getEntity().getType() == EntityType.SLIME) {
                    double damage = e.getDamage();
                    e.setDamage(damage * 0.5D);
                }

            }
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta)item.getItemMeta();
        itemMeta.setColor(Color.fromBGR(255, 102, 102));
        itemMeta.setDisplayName("§aスライムヘルメット");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        List<String> lore = new ArrayList();
        lore.add("§6スライムからのダメージ50%減");
        lore.add("§7なんだかヌメヌメしてる");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
