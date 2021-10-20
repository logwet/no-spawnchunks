package me.logwet.no_spawnchunks;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.Level;

@Environment(EnvType.SERVER)
public class NoSpawnchunksServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        NoSpawnchunks.log(Level.INFO, "Server class initialized!");
    }
}
