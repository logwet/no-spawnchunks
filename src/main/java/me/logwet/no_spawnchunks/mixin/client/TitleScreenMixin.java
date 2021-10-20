package me.logwet.no_spawnchunks.mixin.client;

import me.logwet.no_spawnchunks.NoSpawnchunks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.TitleScreen;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {

	@Inject(method = "init()V", at = @At("HEAD"))
	private void init(CallbackInfo info) {
		NoSpawnchunks.log(Level.INFO, "This line is printed by a TitleScreen mixin!");
	}

}
