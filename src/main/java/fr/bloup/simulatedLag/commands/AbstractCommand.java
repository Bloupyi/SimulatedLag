package fr.bloup.simulatedLag.commands;

import fr.bloup.simulatedLag.SimulatedLag;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class AbstractCommand implements TabExecutor {

    private final Map<String, TabExecutor> subCommands = new HashMap<>();
    protected final SimulatedLag plugin;

    public abstract String getPermission();

    public abstract boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args);

    public void registerSubCommand(String label, TabExecutor subCommand) {
        subCommands.put(label.toLowerCase(), subCommand);
    }

    protected String getUsage(String label) {
        return ChatColor.RED + "Usage: /" + label + " < " + String.join(" | ", this.subCommands.keySet()) + " >";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission(this.getPermission()) && !sender.isOp()) {
            sender.sendMessage("Pas les perms");
            return true;
        }

        if (args.length > 0) {
            TabExecutor child = subCommands.get(args[0].toLowerCase());
            if (child != null) {
                return child.onCommand(sender, command, args[0], removeHead(args));
            }
        }
        return runCommand(sender, command, label, args);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission(this.getPermission()) && !sender.isOp()) {
            return Collections.emptyList();
        }

        if (args.length > 0) {
            TabExecutor child = subCommands.get(args[0].toLowerCase());
            if (child != null) {
                return child.onTabComplete(sender, command, args[0], removeHead(args));
            }
            return subCommands.keySet().parallelStream().filter(cmd -> cmd.startsWith(args[0])).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private String[] removeHead(String[] list) {
        String[] newList = new String[list.length - 1];
        System.arraycopy(list, 1, newList, 0, newList.length);
        return newList;
    }
}