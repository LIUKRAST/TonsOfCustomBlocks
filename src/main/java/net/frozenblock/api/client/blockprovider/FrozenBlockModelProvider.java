package net.frozenblock.api.client.blockprovider;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.frozenblock.TonsOfBlocks.Main;
import net.frozenblock.api.client.block.ConnectedBlockModel;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FrozenBlockModelProvider implements ModelResourceProvider {
    public static final Identifier CONNECTED_BLOCK_MODEL = new Identifier(Main.MODID,"block/connected_block");
    @Override
    public UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) {
        if(identifier.equals(CONNECTED_BLOCK_MODEL)) {
            return new ConnectedBlockModel(new Identifier(Main.MODID, "block/connected_block"));
        } else {
            return null;
        }
    }
}
