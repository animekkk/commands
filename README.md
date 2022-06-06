# anCommands
Create Spigot commands with simple annotations.
Here is example with every possible annotation.
```java
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
```
Only `@CommandName` annotation is required, the rest is optional.

There is also a `PlayerCommand`, for only-players commands.
Remember that it can only be used by **player**.
```java
@CommandName("testplayer")
public class TestPlayerCommand extends Command {

    @Override
    public void onExecute(CommandSender sender, String[] args) {

    }

}
```