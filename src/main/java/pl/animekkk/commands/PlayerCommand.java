package pl.animekkk.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.animekkk.commands.helper.ChatHelper;

public abstract class PlayerCommand extends Command {
    @Override
    public void onExecute(CommandSender sender, String[] args) {
        if(!(sender instanceof Player)) {
            ChatHelper.sendMessage(sender, "&cTej komendy możesz użyć tylko będac na serwerze.");
            return;
        }
        onExecute(((Player) sender), args);
    }

    public abstract void onExecute(Player player, String[] args);
}
