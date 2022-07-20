package net.frozenblock.api.client.blockprovider;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.frozenblock.TonsOfBlocks.Main;
import net.frozenblock.api.client.block.BlockModel;
import net.frozenblock.api.client.block.ConnectedBlockModel;
import net.frozenblock.api.client.registry.RegisterBlockProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

@Environment(EnvType.CLIENT)
public class FrozenBlockModelProvider implements ModelResourceProvider {
    @Override
    public UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) {
        ArrayList<BlockModel> list = RegisterBlockProvider.REGISTERED_CUSTOM_MODELS;
        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (identifier.equals(list.get(i).getModelID())) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}
