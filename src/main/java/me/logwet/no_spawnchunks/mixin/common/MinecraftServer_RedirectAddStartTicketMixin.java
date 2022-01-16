package me.logwet.no_spawnchunks.mixin.common;

import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.util.Unit;
import net.minecraft.util.math.ChunkPos;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftServer.class)
public class MinecraftServer_RedirectAddStartTicketMixin {
    @Redirect(
            method = "prepareStartRegion",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lnet/minecraft/server/world/ServerChunkManager;addTicket(Lnet/minecraft/server/world/ChunkTicketType;Lnet/minecraft/util/math/ChunkPos;ILjava/lang/Object;)V"))
    private void redirectAddTicket(
            ServerChunkManager serverChunkManager,
            ChunkTicketType<Unit> ticketType,
            ChunkPos pos,
            int radius,
            Object argument) {
        NoSpawnchunks.log(Level.INFO, "Prevented spawn chunks loading on initial world load.");
    }
}
