package net.frozenblock.api.client.registry;

import net.frozenblock.api.client.block.BlockModel;

import java.util.ArrayList;

public class RegisterBlockProvider {
    public static ArrayList<BlockModel> REGISTERED_CUSTOM_MODELS = new ArrayList<>();

    public static void registerModel(BlockModel blockModel) {
        REGISTERED_CUSTOM_MODELS.add(blockModel);
    }
}
