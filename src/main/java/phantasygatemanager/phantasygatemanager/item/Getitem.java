//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import phantasygatemanager.phantasygatemanager.item.DevilsAmulet.DevilsAmulet;
import phantasygatemanager.phantasygatemanager.item.DonationItem.CloudBoots;
import phantasygatemanager.phantasygatemanager.item.MagicCompass.MagicCompass;
import phantasygatemanager.phantasygatemanager.item.Pickel.SmeltingPickel;
import phantasygatemanager.phantasygatemanager.item.bossitem.NecromancerOfRod;
import phantasygatemanager.phantasygatemanager.item.normalitem.GoldChain;
import phantasygatemanager.phantasygatemanager.item.normalitem.IronChain;
import phantasygatemanager.phantasygatemanager.item.normalitem.LuminescenceHelmet;
import phantasygatemanager.phantasygatemanager.item.normalitem.SlimeHelmet;
import phantasygatemanager.phantasygatemanager.item.sword.DrainAxe;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Getitem {
    private PhantasyGateManager plugin;
    String[] itemlist = new String[]{"magiccompass", "devilsbag", "devilsamulet", "ironchain", "goldchain", "slimehelmet", "necromancerofrod", "luminescencehelmet", "drainsword", "cloudboots", "smeltingpickel"};

    public Getitem(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    public boolean command(Player p, String[] args) {
        if (!args[0].equals("item")) {
            return false;
        } else if (args[1].equals("get")) {
            if (args[2] == null) {
                p.sendMessage("§4§lERROR : §c名前を入力してください");
            }

            this.get(p, args[2]);
            return true;
        } else if (args[1].equals("help")) {
            this.help(p);
            return true;
        } else if (args[1].equals("list")) {
            this.list(p);
            return true;
        } else {
            return false;
        }
    }

    private void get(Player p, String name) {
        ItemStack item = null;
        if (name.equals("magiccompass")) {
            item = (new MagicCompass(this.plugin)).item();
        }

        if (name.equals("devilsamulet")) {
            item = (new DevilsAmulet(this.plugin)).item();
        }

        if (name.equals("ironchain")) {
            item = (new IronChain(this.plugin)).item();
        }

        if (name.equals("goldchain")) {
            item = (new GoldChain(this.plugin)).item();
        }

        if (name.equals("slimehelmet")) {
            item = (new SlimeHelmet(this.plugin)).item();
        }

        if (name.equals("luminescencehelmet")) {
            item = (new LuminescenceHelmet(this.plugin)).item();
        }

        if (name.equals("necromancerofrod")) {
            item = (new NecromancerOfRod(this.plugin)).item();
        }

        if (name.equals("drainaxe")) {
            item = (new DrainAxe(this.plugin)).item();
        }

        if (name.equals("cloudboots")) {
            item = (new CloudBoots(this.plugin)).item();
        }

        if (name.equals("smeltingpickel")) {
            item = (new SmeltingPickel(this.plugin)).item();
        }

        if (item == null) {
            p.sendMessage("§4§lERROR : §cそのような名前のアイテムはありません");
        } else {
            p.getInventory().addItem(new ItemStack[]{item});
        }
    }

    private void help(Player p) {
        p.sendMessage("§7§l≫ §dPhantasyGate - §eitem");
        p.sendMessage("§e/pgm item get <name>");
        p.sendMessage("§e/pgm item list");
    }

    private void list(Player p) {
        p.sendMessage("§b§l≫ アイテムリスト");
        String[] var2 = this.itemlist;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String str = var2[var4];
            p.sendMessage("§7-§e " + str);
        }

    }
}
