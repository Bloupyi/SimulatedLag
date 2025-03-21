package fr.bloup.simulatedLag.listeners;

import fr.bloup.simulatedLag.SimulatedLag;
import fr.bloup.simulatedLag.packets.PacketManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    private final SimulatedLag plugin;
    private final PacketManager packetManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        plugin.targetedPlayerLag.put(event.getPlayer(), plugin.pluginConfig.getInt("defaultPlayerLag"));
        packetManager.interceptPlayerPackets(event.getPlayer());
    }
}
