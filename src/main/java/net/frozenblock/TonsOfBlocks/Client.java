package net.frozenblock.TonsOfBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.frozenblock.api.client.blockprovider.FrozenBlockModelProvider;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new FrozenBlockModelProvider());
    }
}
