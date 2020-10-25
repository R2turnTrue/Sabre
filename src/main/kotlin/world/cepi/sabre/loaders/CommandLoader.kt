package world.cepi.sabre.loaders

import net.minestom.server.MinecraftServer
import world.cepi.sabre.commands.*
import world.cepi.sabre.commands.monitoring.Ping
import world.cepi.sabre.commands.monitoring.Status
import world.cepi.sabre.commands.security.DeopCommand
import world.cepi.sabre.commands.security.OpCommand
import world.cepi.sabre.commands.security.WhitelistCommand

object CommandLoader : Loader {

    override fun load() {

        val commandManager = MinecraftServer.getCommandManager()

        commandManager.register(KillCommand())
        commandManager.register(StopCommand())
        commandManager.register(TpCommand())
        commandManager.register(GamemodeCommand())
        commandManager.register(OpCommand())
        commandManager.register(DeopCommand())
        commandManager.register(WhitelistCommand())
        commandManager.register(Ping())
        commandManager.register(Status())
    }

}