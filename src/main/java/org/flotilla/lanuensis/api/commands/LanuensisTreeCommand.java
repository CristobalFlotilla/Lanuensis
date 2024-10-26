package org.flotilla.lanuensis.api.commands;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.CommandTreeBase;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class LanuensisTreeCommand extends CommandTreeBase {

    public LanuensisTreeCommand() {
        // Add sub commands
    }

    @Override
    public String getName() {
        return "lanuensis";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.lanuensis.tree_base.usage";
    }
}
