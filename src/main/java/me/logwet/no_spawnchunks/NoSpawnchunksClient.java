package me.logwet.no_spawnchunks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.Level;

@Environment(EnvType.CLIENT)
public class NoSpawnchunksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NoSpawnchunks.log(Level.INFO, "Client class initialized!");
    }
}
