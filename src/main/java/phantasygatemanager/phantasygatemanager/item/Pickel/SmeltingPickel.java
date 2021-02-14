//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item.Pickel;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.ItemSubFunctions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SmeltingPickel implements Listener {
    private PhantasyGateManager plugin;

    public SmeltingPickel(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void click(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if ((new ItemSubFunctions()).IsThere(e.getPlayer(), this.item())) {
            Block block = e.getBlock();
            Location loc = block.getLocation();
            loc.setX(loc.getX() + 0.5D);
            loc.setZ(loc.getZ() + 0.5D);
            if (block.getType() == Material.IRON_ORE) {
                e.setDropItems(false);
                block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.IRON_INGOT));
            }

            if (block.getType() == Material.GOLD_ORE) {
                e.setDropItems(false);
                block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.GOLD_INGOT));
            }

        }
    }

    public ItemStack item() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§b§l精錬ツルハシ");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        itemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        List<String> lore = new ArrayList();
        lore.add("§7火がまとっているツルハシ");
        lore.add("§7鉱石を掘ることで精錬した状態の鉱石を入手できる");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }
}
