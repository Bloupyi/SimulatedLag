package fr.bloup.simulatedLag.utils;

import fr.bloup.simulatedLag.SimulatedLag;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class DelayUtils {
    private final SimulatedLag plugin;

    /**
     * Calculates the packet delay for a player based on their targeted ping.
     * 
     * @param player The player whose delay should be calculated.
     * @return The delay in milliseconds before processing packets.
     */
    public int getDelayForPlayerLag(Player player) {
        int targetedPing = plugin.targetedPlayerLag.getOrDefault(player,plugin.pluginConfig.getInt("defaultPlayerLag"));
        int currentPing = player.getPing();

        // Apply a delay only if the targeted ping is higher than the current ping
        // The delay is divided by 2 because packets are processed twice (incoming & outgoing)
        return (currentPing < targetedPing) ? (targetedPing - currentPing) / 2 : 0;
    }
}
