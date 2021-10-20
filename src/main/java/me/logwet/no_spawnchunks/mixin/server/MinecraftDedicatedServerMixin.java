package me.logwet.no_spawnchunks.mixin.server;

import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.SERVER)
@Mixin(MinecraftDedicatedServer.class)
public abstract class MinecraftDedicatedServerMixin {

    @Inject(method = "setupServer", at = @At("HEAD"))
    private void setupServer(CallbackInfoReturnable<Boolean> cir) {
        NoSpawnchunks.log(Level.INFO, "This line is printed by a MinecraftDedicatedServer mixin!");
    }

}
