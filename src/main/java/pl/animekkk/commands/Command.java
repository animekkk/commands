package pl.animekkk.commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import pl.animekkk.commands.annotations.*;
import pl.animekkk.commands.helper.ChatHelper;

import java.util.Arrays;
public abstract class Command extends org.bukkit.command.Command {

    public Command() {
        super("");

        CommandName name = this.getClass().getAnnotation(CommandName.class);
        if(name == null) throw new RuntimeException("Command must have a name.");
        this.setName(name.value());

        CommandDescription commandDescription = this.getClass().getAnnotation(CommandDescription.class);
        if(commandDescription != null) this.setDescription(commandDescription.value());

        CommandUsage commandUsage = this.getClass().getAnnotation(CommandUsage.class);
        if(commandUsage != null) this.setUsage(commandUsage.value());

        CommandAliases commandAliases = this.getClass().getAnnotation(CommandAliases.class);
        if(commandAliases != null) this.setAliases(Arrays.asList(commandAliases.value().split("\\|")));

        CommandPermission commandPermission = this.getClass().getAnnotation(CommandPermission.class);
        if(commandPermission != null) this.setPermission(commandPermission.value());
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if(this.getPermission() != null && !this.getPermission().equals("")) {
            if(!sender.hasPermission(this.getPermission())) {
                if(this.getPermissionMessage() != null)
                    ChatHelper.sendMessage(sender, "&cNie masz dostępu do tej komendy. (" + this.getPermission() + ")");
                return true;
            }
        }
        this.onExecute(sender, args);
        return true;
    }

    public abstract void onExecute(CommandSender sender, String[] args);

    public void sendUsage(CommandSender commandSender) {
        ChatHelper.sendMessage(commandSender, "&7Poprawne użycie: &3" + this.getUsage());
    }

}
