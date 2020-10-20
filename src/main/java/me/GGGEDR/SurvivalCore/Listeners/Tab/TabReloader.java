package me.GGGEDR.SurvivalCore.Listeners.Tab;

import me.GGGEDR.SurvivalCore.Main;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabReloader {

    private static List<Player> players = new ArrayList<>();

    public static void addPlayer(Player p){
        players.add(p);
    }

    public static void remPlayer(Player p){
        players.remove(p);
    }

    public static void setTab(Player p){
        User user = Main.getLuckPerms().getUserManager().getUser(p.getName());
        p.setPlayerListHeader("§c§lDomain.eu");
        p.setPlayerListFooter("§fOnline: §c"+ Bukkit.getOnlinePlayers().size() +"§7/§c"+ Bukkit.getServer().getMaxPlayers() +"  §fRank: §c"+ Main.getLuckPerms().getGroupManager().getGroup(user.getPrimaryGroup()).getDisplayName());
    }

    public static void startTimer(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(!players.isEmpty()){
                    for(Player p : players){
                        setTab(p);
                    }
                }
            }
        }, 0, 20*5);
    }
}
