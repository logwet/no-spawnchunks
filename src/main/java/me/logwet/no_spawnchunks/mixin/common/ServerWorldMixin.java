package me.logwet.no_spawnchunks.mixin.common;

import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Unit;
import net.minecraft.util.math.ChunkPos;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

    @Redirect(method = "setSpawnPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerChunkManager;removeTicket(Lnet/minecraft/server/world/ChunkTicketType;Lnet/minecraft/util/math/ChunkPos;ILjava/lang/Object;)V"))
    private void redirectRemoveTicket(ServerChunkManager serverChunkManager, ChunkTicketType<Unit> ticketType, ChunkPos pos, int radius, Object argument) {
        NoSpawnchunks.log(Level.INFO, "Prevented spawn chunks unloading on spawn point change.");
    }

    @Redirect(method = "setSpawnPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerChunkManager;addTicket(Lnet/minecraft/server/world/ChunkTicketType;Lnet/minecraft/util/math/ChunkPos;ILjava/lang/Object;)V"))
    private void redirectAddTicket(ServerChunkManager serverChunkManager, ChunkTicketType<Unit> ticketType, ChunkPos pos, int radius, Object argument) {
        NoSpawnchunks.log(Level.INFO, "Prevented spawn chunks loading on spawn point change.");
    }

}
