//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager;

import phantasygatemanager.phantasygatemanager.item.Getitem;
import phantasygatemanager.phantasygatemanager.main.OnJoinPlayer.JoinPlayer;
import phantasygatemanager.phantasygatemanager.main.basis.ShowHelp;
import phantasygatemanager.phantasygatemanager.main.basis.ShowMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCommand implements CommandExecutor {
    private PhantasyGateManager plugin;

    public GetCommand(PhantasyGateManager plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        if (args.length == 0) {
            (new ShowMenu(this.plugin)).open(p);
            return true;
        } else if (args[0].equals("item")) {
            (new Getitem(this.plugin)).command(p, args);
            return true;
        } else if (args[0].equals("firstspawn")) {
            (new JoinPlayer(this.plugin)).SetFirstSpawn(p);
            return true;
        } else if (args[0].equals("help")) {
            (new ShowHelp(this.plugin)).show(p);
            return true;
        } else {
            return false;
        }
    }
}
