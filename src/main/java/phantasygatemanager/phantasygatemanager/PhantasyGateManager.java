//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package phantasygatemanager.phantasygatemanager;

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
import phantasygatemanager.phantasygatemanager.main.OnJoinPlayer.JoinPlayer;
import phantasygatemanager.phantasygatemanager.main.OnJoinPlayer.LeavePlayer;
import phantasygatemanager.phantasygatemanager.main.Respawn.RespawnPlayer;
import phantasygatemanager.phantasygatemanager.main.basis.ShowMenu;
import phantasygatemanager.phantasygatemanager.main.basis.UnabaleGoHell;
import phantasygatemanager.phantasygatemanager.util.status.Lifetime;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhantasyGateManager extends JavaPlugin {
    public String logo = "§d§l[Phantasy Gate]";
    public CustomConfig config;
    public CustomConfig status;

    public PhantasyGateManager() {
    }

    public void onEnable() {
        Bukkit.getPluginCommand("pgm").setExecutor(new GetCommand(this));
        Bukkit.getPluginManager().registerEvents(new JoinPlayer(this), this);
        Bukkit.getPluginManager().registerEvents(new RespawnPlayer(this), this);
        Bukkit.getPluginManager().registerEvents(new ShowMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new LeavePlayer(this), this);
        Bukkit.getPluginManager().registerEvents(new MagicCompass(this), this);
        Bukkit.getPluginManager().registerEvents(new DevilsAmulet(this), this);
        Bukkit.getPluginManager().registerEvents(new IronChain(this), this);
        Bukkit.getPluginManager().registerEvents(new GoldChain(this), this);
        Bukkit.getPluginManager().registerEvents(new SlimeHelmet(this), this);
        Bukkit.getPluginManager().registerEvents(new LuminescenceHelmet(this), this);
        Bukkit.getPluginManager().registerEvents(new DrainAxe(this), this);
        Bukkit.getPluginManager().registerEvents(new CloudBoots(this), this);
        Bukkit.getPluginManager().registerEvents(new SmeltingPickel(this), this);
        Bukkit.getPluginManager().registerEvents(new NecromancerOfRod(this), this);
        Bukkit.getPluginManager().registerEvents(new UnabaleGoHell(this), this);
        this.config = new CustomConfig(this);
        this.config.saveDefaultConfig();
        this.status = new CustomConfig(this, "status.yml");
        this.status.saveDefaultConfig();
        (new Lifetime(this)).runTaskTimer(this, 0L, 20L);
    }

    public void onDisable() {
    }
}
