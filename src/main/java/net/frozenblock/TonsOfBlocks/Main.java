package net.frozenblock.TonsOfBlocks;

import net.fabricmc.api.ModInitializer;
import net.frozenblock.TonsOfBlocks.registry.RegisterBlocks;

public class Main implements ModInitializer {

    public static final String MODID = "frozenblock";

    @Override
    public void onInitialize() {
        RegisterBlocks.registerBlocks();
    }
}
