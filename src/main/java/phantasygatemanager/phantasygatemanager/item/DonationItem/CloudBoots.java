//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.DonationItem;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CloudBoots implements Listener {
    private PhantasyGateManager plugin;

    public CloudBoots(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((new ItemSubFunctions()).IsThere(e.getPlayer(), this.item(), 5)) {
            p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation(), 2, 0.1D, 0.1D, 0.1D);
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta)item.getItemMeta();
        itemMeta.setColor(Color.WHITE);
        itemMeta.setDisplayName("§f§lもくも靴");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        List<String> lore = new ArrayList();
        lore.add("§d寄付者限定アイテム");
        lore.add("§7歩くともくもくするよ!");
        lore.add("");
        lore.add("§c寄付者以外の人が所持したり、譲渡したら処罰の対象となります");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
