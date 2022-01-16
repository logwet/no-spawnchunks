package me.logwet.no_spawnchunks.mixin.client;

import java.util.List;
import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(DebugHud.class)
public abstract class DebugHudMixin {
    /**
     * @author DuncanRuns
     * @reason Puts mod notice in F3 menu
     */
    @Inject(at = @At("RETURN"), method = "getLeftText", cancellable = true)
    private void injectGetLeftText(CallbackInfoReturnable<List<String>> info) {
        info.getReturnValue()
                .add(NoSpawnchunks.MODID + " mod v" + NoSpawnchunks.VERSION + " by logwet");
    }
}
