package me.GGGEDR.SurvivalCore.Listeners.JoinLeaveMessages;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessagesJoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("§a§l+§8 | §c"+ e.getPlayer().getName() +" §7joined to game");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        e.setQuitMessage("§c§l-§8 | §c"+ e.getPlayer().getName() +" §7left the game");
    }
}
