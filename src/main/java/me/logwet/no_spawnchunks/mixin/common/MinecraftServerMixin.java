package me.logwet.no_spawnchunks.mixin.common;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ChunkTicketType;
import net.minecraft.server.world.ServerChunkManager;
import net.minecraft.util.Unit;
import net.minecraft.util.math.ChunkPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Redirect(method = "prepareStartRegion", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerChunkManager;addTicket(Lnet/minecraft/server/world/ChunkTicketType;Lnet/minecraft/util/math/ChunkPos;ILjava/lang/Object;)V"))
    private void redirectAddTicket(ServerChunkManager serverChunkManager, ChunkTicketType<Unit> ticketType, ChunkPos pos, int radius, Object argument) {
        return;
    }

    @Redirect(method = "prepareStartRegion", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerChunkManager;getTotalChunksLoadedCount()I"))
    private int redirectGetTotalChunksLoadedCount(ServerChunkManager serverChunkManager) {
        return 1;
    }

    @ModifyConstant(method = "prepareStartRegion", constant = @Constant(intValue = 441))
    private int modifyNumChunksToWaitFor(int value) {
        return 1;
    }

}
