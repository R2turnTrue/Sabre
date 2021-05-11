package world.cepi.sabre.loaders

import com.google.common.base.Strings
import net.kyori.adventure.text.Component
import net.minestom.server.MinecraftServer
import net.minestom.server.command.CommandSender
import net.minestom.server.utils.callback.CommandCallback
import world.cepi.kstom.Manager
import world.cepi.kstom.command.register
import world.cepi.sabre.commands.security.DeopCommand
import world.cepi.sabre.commands.security.OpCommand
import world.cepi.sabre.Config.Companion.config
import world.cepi.sabre.commands.StopCommand

internal fun commandLoader() {

    if (!Strings.isNullOrEmpty(config.unknownMessage)) {
        Manager.command.unknownCommandCallback =
            CommandCallback { sender: CommandSender, command: String ->
                if (!Strings.isNullOrEmpty(command)) {
                    sender.sendMessage(Component.text(config.unknownMessage))
                }
            }
    }

    StopCommand.register()

    if (config.opUtilities) {
        OpCommand.register()
        DeopCommand.register()
    }


}
