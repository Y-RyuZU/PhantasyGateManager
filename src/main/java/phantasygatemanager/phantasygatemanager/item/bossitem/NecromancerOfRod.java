//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.bossitem;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NecromancerOfRod implements Listener {
    private PhantasyGateManager plugin;

    public NecromancerOfRod(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void click(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player) {
            Player damager = e.getPlayer();
            Player player = (Player)e.getRightClicked();
            if ((new ItemSubFunctions()).IsThere(damager, this.item())) {
                damager.spawnParticle(Particle.HEART, player.getLocation(), 50, 2.0D, 2.0D, 3.0D);
                damager.playSound(damager.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                double newHealth = player.getHealth() + 3.0D;
                if (newHealth > 20.0D) {
                    newHealth = 20.0D;
                }

                player.setHealth(newHealth);
                damager.damage(6.0D);
                ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
                item.setDurability((short)(item.getDurability() + 3));
                if (item.getDurability() >= 250) {
                    damager.getInventory().setItemInMainHand(new ItemStack(Material.IRON_INGOT));
                    damager.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
                }

            }
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.IRON_HOE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§d§lネクロマンサーの§5§l杖");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add("§c右クリックした相手を自分のHPと引き換えに回復させる");
        lore.add("§7ネクロマンサーが生み出したとされる");
        lore.add("§7使いすぎると、己を滅ぼす");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
