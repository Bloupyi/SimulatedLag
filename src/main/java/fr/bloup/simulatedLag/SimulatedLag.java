package fr.bloup.simulatedLag;

import fr.bloup.simulatedLag.commands.SimulatedLagCommand;
import fr.bloup.simulatedLag.listeners.PlayerJoinListener;
import fr.bloup.simulatedLag.listeners.PlayerQuitListener;
import fr.bloup.simulatedLag.packets.PacketManager;
import fr.bloup.simulatedLag.utils.DelayUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.logging.Logger;

public final class SimulatedLag extends JavaPlugin {
    public Logger log = getLogger();
    public FileConfiguration pluginConfig;

    public HashMap<Player,Integer> targetedPlayerLag = new HashMap<>();

    @Override
    public void onEnable() {
        log.info("Enabled "+ this.getDescription().getName() + " " +  this.getDescription().getVersion());
        saveDefaultConfig();

        pluginConfig = getConfig();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this,new PacketManager(new DelayUtils(this))), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(new PacketManager(new DelayUtils(this))), this);

        this.getCommand("simulatedlag").setExecutor(new SimulatedLagCommand(this));
    }

    @Override
    public void onDisable() {
        log.info("Disabled "+ this.getDescription().getName() + " " +  this.getDescription().getVersion());
    }

    /**
     * Sets a targeted lag (ping) for a specific player.
     *
     * @param player The player whose lag is being modified.
     * @param ms     The lag in milliseconds to apply.
     */
    public void setPlayerTargetedLag(Player player, Integer ms) {
        targetedPlayerLag.put(player,ms);
    }
}
