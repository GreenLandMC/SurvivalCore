package me.GGGEDR.SurvivalCore.Listeners.Chat;

import me.GGGEDR.SurvivalCore.Main;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
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
        e.setFormat(String.format("%s%s §8» %s%s", prefix, e.getPlayer().getName(), chat_color, e.getMessage()));
    }
}
