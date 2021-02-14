//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.normalitem;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LuminescenceHelmet implements Listener {
    private PhantasyGateManager plugin;

    public LuminescenceHelmet(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((new ItemSubFunctions()).IsThere(e.getPlayer(), this.item(), 2)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 1));
        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.GOLD_HELMET);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§e§lルミネセンスヘルメット");
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        List<String> lore = new ArrayList();
        lore.add("§7ライトがついている");
        lore.add("§7プレイヤーは常時暗視状態になる");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
