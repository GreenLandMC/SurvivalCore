package me.GGGEDR.SurvivalCore.Commands.AdvertisedCommand;

import me.GGGEDR.SurvivalCore.Main;
import org.bukkit.Bukkit;

public class Countdown {

    private String player;
    private int timer;
    private int time = 60;


    public Countdown(String pl){
        player = pl;
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
        AdvertisedCache.removeFromCache(player);
    }


    public int getTime() {
        return time;
    }
}
