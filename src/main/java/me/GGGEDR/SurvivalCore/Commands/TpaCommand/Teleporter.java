package me.GGGEDR.SurvivalCore.Commands.TpaCommand;

import me.GGGEDR.SurvivalCore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Teleporter {

    private int time = 30;
    private Player teleporter;
    private Player teleport_to;
    private int timer;

    public Teleporter(Player from, Player to){
        teleporter = from;
        teleport_to = to;
    }

    public void startTiming(){
        timer = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(time != 0){
                    time--;
                } else {
                    stopTiming();
                }
            }
        }, 0, 20);
    }

    public void stopTiming(){
        Bukkit.getScheduler().cancelTask(timer);
        TpaCache.removeFromCache(teleporter.getName());
    }

    public void accept(){
        if(time != 0){
            teleporter.teleport(teleport_to.getLocation());
            stopTiming();
        }
    }

    public void cancel(){
        if(time != 0){
            stopTiming();
        }
    }

    public Player getTeleporter(){
        return teleporter;
    }

    public Player getTeleport_to(){
        return teleport_to;
    }
}
