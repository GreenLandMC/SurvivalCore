package me.GGGEDR.SurvivalCore.Listeners.Tab;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        TabReloader.addPlayer(e.getPlayer());
        TabReloader.setTab(e.getPlayer());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        TabReloader.remPlayer(e.getPlayer());
    }
}
