package me.GGGEDR.SurvivalCore.Commands.AdvertisedCommand;

import java.util.Collection;
import java.util.HashMap;

public class AdvertisedCache {

    private static HashMap<String, Countdown> cache = new HashMap<>();

    public static boolean isInCache(String player){
        return cache.containsKey(player);
    }

    public static void addToCache(String player, Countdown countdown){
        if(!cache.containsKey(player)) {
            cache.put(player, countdown);
        } else {
            cache.remove(player);
            cache.put(player, countdown);
        }
    }

    public static void removeFromCache(String player){
        if(cache.containsKey(player)) {
            cache.remove(player);
        }
    }

    public static Countdown getBoolean(String player){
        return cache.get(player);
    }
}
