package fr.bloup.simulatedLag.listeners;

import fr.bloup.simulatedLag.packets.PacketManager;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {
    private final PacketManager packetManager;

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        packetManager.removePlayerFromChannel(event.getPlayer());
    }
}
