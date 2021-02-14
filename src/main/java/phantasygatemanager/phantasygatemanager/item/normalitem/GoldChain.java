//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.normalitem;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GoldChain implements Listener {
    private PhantasyGateManager plugin;

    public GoldChain(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void damaged(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            Player p = (Player)e.getEntity();
            if ((new ItemSubFunctions()).IsThere(p, this.item(), 1)) {
                double damage = e.getDamage();
                e.setDamage(damage - 4.0D);
                int pro = 40;
                if ((new Random()).nextInt(pro) == 0) {
                    p.getInventory().setItemInOffHand((ItemStack)null);
                    p.sendMessage("§e§l金の§7§l鎖§4は砕けてしまった...");
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
                }

            }
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§e§l金の§8§l鎖");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add("§74ダメージ軽減");
        lore.add("§7使っていると稀に壊れてしまう");
        lore.add("§e重ねずにオフハンドに持ってね!");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
