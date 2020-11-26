package me.GGGEDR.SurvivalCore.Listeners;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import me.GGGEDR.SurvivalCore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        p.sendActionBar("§ax: §f"+ (int) p.getLocation().getBlockX() +" §ay: §f"+ (int) p.getLocation().getY() +" §az: §f"+ (int) p.getLocation().getZ());
    }

    @EventHandler
    public void onMove(PlayerJumpEvent e){
        Player p = e.getPlayer();
        p.sendActionBar("§ax: §f"+ (int) p.getLocation().getBlockX() +" §ay: §f"+ (int) p.getLocation().getY() +" §az: §f"+ (int) p.getLocation().getZ());
    }
}
