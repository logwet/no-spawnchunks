package me.logwet.no_spawnchunks.mixin.common;

import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerChunkManager;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MinecraftServer.class, priority = 1100)
public abstract class MinecraftServer_SkipWaitForChunkGenMixin {

    @Redirect(method = "prepareStartRegion", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerChunkManager;getTotalChunksLoadedCount()I"))
    private int redirectGetTotalChunksLoadedCount(ServerChunkManager serverChunkManager) {
        NoSpawnchunks.log(Level.INFO, "Redirected chunk count call.");
        return 1;
    }

    @ModifyConstant(method = "prepareStartRegion", constant = @Constant(intValue = 441))
    private int modifyNumChunksToWaitFor(int value) {
        NoSpawnchunks.log(Level.INFO, "Modified targeted chunk count constant.");
        return 1;
    }

    /**
     * @author Gregor0410
     * @reason https://github.com/Mario0051/chunk-mod/issues/3
     */
    @Inject(method = "prepareStartRegion", at = @At("TAIL"))
    private void injectWorldSave(CallbackInfo info) {
        NoSpawnchunks.log(Level.INFO, "Forcing world save to ensure advancements and stats files are written.");
        ((MinecraftServer) (Object) this).save(false,false,false);
    }

}
