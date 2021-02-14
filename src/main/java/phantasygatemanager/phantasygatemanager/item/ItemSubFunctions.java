//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSubFunctions {
    public ItemSubFunctions() {
    }

    public boolean IsThere(Player p, ItemStack item) {
        return this.IsThere(p, item, 0);
    }

    public boolean IsThere(Player p, ItemStack item, int where) {
        ItemStack playersitem = null;
        switch(where) {
            case 0:
                playersitem = p.getInventory().getItemInMainHand();
                break;
            case 1:
                playersitem = p.getInventory().getItemInOffHand();
                break;
            case 2:
                playersitem = p.getInventory().getHelmet();
                break;
            case 3:
                playersitem = p.getInventory().getItemInOffHand();
                break;
            case 4:
                playersitem = p.getInventory().getItemInOffHand();
        }

        if (playersitem == null) {
            return false;
        } else if (playersitem.getType() != item.getType()) {
            return false;
        } else {
            return playersitem.getItemMeta().serialize().equals(item.getItemMeta().serialize());
        }
    }
}
