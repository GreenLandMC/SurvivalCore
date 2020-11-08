package me.GGGEDR.SurvivalCore.Listeners.Chat;

import me.GGGEDR.GreenTags.Storage.Data;
import me.GGGEDR.GreenTags.StorageProvider;
import me.GGGEDR.SurvivalCore.Main;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Optional;

public class ChatListener implements Listener {

    @EventHandler
    public void onChatting(AsyncPlayerChatEvent e){
        User user = Main.getLuckPerms().getUserManager().getUser(e.getPlayer().getName());
        Optional<QueryOptions> queryOptions = Main.getLuckPerms().getContextManager().getQueryOptions(user);
        CachedMetaData metaData = user.getCachedData().getMetaData(queryOptions.get());
        String prefix = metaData.getPrefix();
        String chat_color = metaData.getSuffix();
        StorageProvider storageProvider = new StorageProvider();
        storageProvider.loadData();
        Data data = storageProvider.getDataEditor();
        if(e.getPlayer().hasPermission("chat.color")) {
            if(data.isTagSelected(e.getPlayer())) {
                Bukkit.broadcastMessage(String.format("%s §8| §f%s §8» %s%s", metaData.getSuffix() + data.getTag(e.getPlayer()).getPrefix(), e.getPlayer().getName(), ChatColor.translateAlternateColorCodes('&', chat_color), ChatColor.translateAlternateColorCodes('&', e.getMessage())));
                e.setCancelled(true);
            } else {
                Bukkit.broadcastMessage(String.format("%s%s §8» %s%s", ChatColor.translateAlternateColorCodes('&', prefix), e.getPlayer().getName(), ChatColor.translateAlternateColorCodes('&', chat_color), ChatColor.translateAlternateColorCodes('&', e.getMessage())));
                e.setCancelled(true);
            }
        } else {
            if(data.isTagSelected(e.getPlayer())) {
                Bukkit.broadcastMessage(String.format("%s §8| §f%s §8» %s%s", metaData.getSuffix() + data.getTag(e.getPlayer()).getPrefix(), e.getPlayer().getName(), ChatColor.translateAlternateColorCodes('&', chat_color), e.getMessage()));
                e.setCancelled(true);
            } else {
                Bukkit.broadcastMessage(String.format("%s%s §8» %s%s", ChatColor.translateAlternateColorCodes('&', prefix), e.getPlayer().getName(), ChatColor.translateAlternateColorCodes('&', chat_color), e.getMessage()));
                e.setCancelled(true);
            }
        }
    }
}
