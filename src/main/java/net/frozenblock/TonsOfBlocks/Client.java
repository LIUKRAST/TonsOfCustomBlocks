package net.frozenblock.TonsOfBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.networking.v1.S2CPlayChannelEvents;
import net.frozenblock.api.client.block.BlockModel;
import net.frozenblock.api.client.block.ConnectedBlockModel;
import net.frozenblock.api.client.block.VerticalConnectedBlockModel;
import net.frozenblock.api.client.blockprovider.FrozenBlockModelProvider;
import net.frozenblock.api.client.registry.RegisterBlockProvider;
import net.minecraft.util.Identifier;

public class Client implements ClientModInitializer {

    public static final BlockModel CONNECTED_BLOCK_MODEL = new ConnectedBlockModel(
            new Identifier(Main.MODID, "block/connected_block"),
            new Identifier(Main.MODID, "block/connected_block"));
    public static final BlockModel VERTICAL_CONNECTED_BLOCK_MODEL = new VerticalConnectedBlockModel(
            new Identifier(Main.MODID, "block/vertical_connected_block"),
            new Identifier(Main.MODID, "block/vertical_connected_block"));
    @Override
    public void onInitializeClient() {
        RegisterBlockProvider.registerModel(VERTICAL_CONNECTED_BLOCK_MODEL);

        // this must be at the end
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new FrozenBlockModelProvider());
    }
}
