package me.GGGEDR.SurvivalCore.Commands.TpaCommand;

import java.util.HashMap;

public class TpaCache {

    private static HashMap<String, Teleporter> cache = new HashMap<>();

    public static boolean isInCache(String player){
        return cache.containsKey(player);
    }

    public static void addToCache(String player, Teleporter teleporter){
        if(!cache.containsKey(player)) {
            cache.put(player, teleporter);
        } else {
            cache.remove(player);
            cache.put(player, teleporter);
        }
    }

    public static void removeFromCache(String player){
        if(cache.containsKey(player)) {
            cache.remove(player);
        }
    }

    public static Teleporter getTeleporterClass(String player){
        return cache.get(player);
    }
}
