package world.cepi.sabre.loaders

import net.minestom.server.MinecraftServer
import world.cepi.sabre.Config.Companion.config

object ThresholdLoader : Loader {

    override fun load() {
        MinecraftServer.setCompressionThreshold(config.compressionThreshold)
        MinecraftServer.setPacketCaching(config.cachePackets)
    }

}