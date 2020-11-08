package me.GGGEDR.SurvivalCore.Listeners.JoinLeaveMessages;


import me.GGGEDR.GreenTags.Storage.Data;
import me.GGGEDR.GreenTags.StorageProvider;
import me.GGGEDR.SurvivalCore.Listeners.Move;
import me.GGGEDR.Vanish.Events.onVanishChangeEvent;
import me.GGGEDR.Vanish.Mysql.StorageManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class MessagesJoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException {
        StorageManager storageManager = new StorageManager();
        StorageProvider provider = new StorageProvider();
        provider.loadData();
        Data data = provider.getDataEditor();
        data.createPlayer(e.getPlayer());
        data.save();
        if(storageManager.getVanish(e.getPlayer().getName())){
            e.setJoinMessage(null);
        } else {
            e.setJoinMessage("§a§l+§8 | §a" + e.getPlayer().getName() + " §7joined to game");
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        StorageManager storageManager = new StorageManager();
        if(storageManager.getVanish(e.getPlayer().getName())){
            e.setQuitMessage(null);
        } else {
            e.setQuitMessage("§c§l-§8 | §a"+ e.getPlayer().getName() +" §7left the game");
        }
    }

    @EventHandler
    public void onVanishChange(onVanishChangeEvent e){
        if(e.isEnabled()){
            Bukkit.broadcastMessage("§c§l-§8 | §a"+ e.getPlayer().getName() +" §7left the game");
        } else {
            Bukkit.broadcastMessage("§a§l+§8 | §a" + e.getPlayer().getName() + " §7joined to game");
        }
    }
}
