//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager.main.basis;

import phantasygatemanager.phantasygatemanager.PhantasyGateManager;
import org.bukkit.entity.Player;

public class ShowHelp {
    private PhantasyGateManager plugin;

    public ShowHelp(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    public void show(Player p) {
        p.sendMessage("§d§l§kXXX§f§l  PhantasyGateManager §7§lHELP §d§l§kXXX");
        p.sendMessage("§ehelp §7-HELPの表示");
        p.sendMessage("§efirstspawn §7-初期スポーン地点の設定");
        p.sendMessage("§eitem help §7-ITEM HELPの表示");
    }
}
