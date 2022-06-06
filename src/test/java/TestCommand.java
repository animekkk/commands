import org.bukkit.command.CommandSender;
import pl.animekkk.commands.Command;
import pl.animekkk.commands.annotations.*;

@CommandName("testcommand")
@CommandDescription("This is description for command.")
@CommandUsage("/test <player>")
@CommandPermission("test.test")
@CommandAliases("test|tst|t")
public class TestCommand extends Command {

    @Override
    public void onExecute(CommandSender sender, String[] args) {
        //Doing stuff here
    }

}
