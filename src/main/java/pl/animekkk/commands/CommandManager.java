package pl.animekkk.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.util.List;

public class CommandManager {

    private final CommandMap commandMap;

    public CommandManager() {
        this.commandMap = Bukkit.getServer().getCommandMap();
    }

    public void registerCommand(Command command) {
        this.commandMap.register(command.getName(), command);
    }

    public void registerCommands(List<Command> commands) {
        commands.forEach(this::registerCommand);
    }

}
