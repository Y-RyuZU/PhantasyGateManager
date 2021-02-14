//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.basis;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ShowMenu implements Listener {
    private PhantasyGateManager plugin;
    private String name = "§7§lPhantasyGate Menu";

    public ShowMenu(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    public void open(Player p) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, 45, this.name);
        inv = this.setitem(p, inv);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CAT_AMBIENT, 1.0F, 1.0F);
        p.openInventory(inv);
    }

    private Inventory setitem(Player p, Inventory inv) {
        ItemStack item = new ItemStack(Material.ENDER_PEARL);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§bLobby へ 戻る");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックでLobbyへ戻れます");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(13, item);
        item = new ItemStack(Material.GOLD_BLOCK);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§6CASINO§e へ行く");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックでカジノへワープできます");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(14, item);
        item = new ItemStack(Material.PURPLE_SHULKER_BOX);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§6SHOP§e へ行く");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックでショップへワープできます");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(15, item);
        item = new ItemStack(Material.LOG);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§a建築ワールド§e へ行く");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックで建築ワールドへワープできます");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(16, item);
        item = new ItemStack(Material.GRASS);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§a資源ワールド§e へ行く");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        lore = new ArrayList();
        lore.add("");
        lore.add("§eクリックで資源ワールドへワープできます");
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        inv.setItem(17, item);
        item = new ItemStack(Material.STONE);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(" ");
        item.setItemMeta(itemMeta);

        for(int i = 0; i < 9; ++i) {
            inv.setItem(i, item);
            inv.setItem(i + 36, item);
        }

        ItemStack skullitem = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullMeta = (SkullMeta)skullitem.getItemMeta();
        skullMeta.setDisplayName("§e§l" + p.getName());
        skullMeta.setOwningPlayer(p);
        int time = this.plugin.status.getConfig().getInt("status.lifetime." + p.getUniqueId());
        lore = new ArrayList();
        lore.add("§6§l§m==§f§l  your status  §6§l§m==");
        lore.add("§a§lEXP : §f" + p.getTotalExperience());
        lore.add("§1§lTIME : §f" + time / 3600 + "h " + time / 60 % 60 + "m " + time % 60 + "s");
        skullMeta.setLore(lore);
        skullitem.setItemMeta(skullMeta);
        inv.setItem(19, skullitem);
        return inv;
    }

    @EventHandler
    public void click(InventoryClickEvent e) {
        if (e.getInventory().getName() != null) {
            if (e.getInventory().getName().equals(this.name)) {
                e.setCancelled(true);
                Player p = (Player)e.getWhoClicked();
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
                    Double x = this.plugin.config.getConfig().getDouble("config.firstspawn.x");
                    Double y = this.plugin.config.getConfig().getDouble("config.firstspawn.y");
                    Double z = this.plugin.config.getConfig().getDouble("config.firstspawn.z");
                    World w = Bukkit.getWorld(this.plugin.config.getConfig().getString("config.firstspawn.w"));
                    e.getWhoClicked().teleport(new Location(w, x, y, z));
                }

                if (e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                    p.teleport(new Location(Bukkit.getWorld("casino"), -324.0D, 5.0D, -690.0D));
                }

                if (e.getCurrentItem().getType() == Material.PURPLE_SHULKER_BOX) {
                    p.teleport(new Location(Bukkit.getWorld("casino"), -360.0D, 5.0D, -873.0D));
                }

                if (e.getCurrentItem().getType() == Material.LOG) {
                    p.teleport(new Location(Bukkit.getWorld("build"), 51.0D, 64.0D, 444.0D));
                }

                if (e.getCurrentItem().getType() == Material.GRASS) {
                    p.teleport(Bukkit.getWorld("shigen").getSpawnLocation());
                }
            }
        }
    }
}
