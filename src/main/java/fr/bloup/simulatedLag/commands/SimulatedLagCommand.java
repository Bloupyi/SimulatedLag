package fr.bloup.simulatedLag.commands;

import fr.bloup.simulatedLag.SimulatedLag;
import fr.bloup.simulatedLag.utils.DelayUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimulatedLagCommand extends AbstractCommand {

    public SimulatedLagCommand(SimulatedLag plugin) {
        super(plugin);
    }

    @Override
    public String getPermission() {
        return "simulatedlag.admin";
    }

    @Override
    public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
        if (args.length > 0 && !Objects.equals(Bukkit.getPlayer(args[0]),null)) {
            if (args.length > 1 && args[1].matches("-?\\d+")) {
                plugin.setPlayerTargetedLag((Player) sender,Integer.parseInt(args[1]));
                sender.sendMessage("[Lag] Targeted Ping of " + Bukkit.getPlayer(args[0]).getName() + " is now: " + Integer.parseInt(args[1]));
            } else {
                sender.sendMessage("[Lag] "+Bukkit.getPlayer(args[0]).getName()+"'s normal Ping: " + Bukkit.getPlayer(args[0]).getPing());
                sender.sendMessage("[Lag] "+Bukkit.getPlayer(args[0]).getName()+"'s targeted Ping: " + plugin.targetedPlayerLag.get(Bukkit.getPlayer(args[0])));
                sender.sendMessage("[Lag] "+Bukkit.getPlayer(args[0]).getName()+"'s packets delay: " + new DelayUtils(plugin).getDelayForPlayerLag(Bukkit.getPlayer(args[0])));
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command rootCommand, String label, String[] args) {
        return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
    }
}
