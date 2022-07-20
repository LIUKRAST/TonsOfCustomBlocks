package net.frozenblock.TonsOfBlocks.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frozenblock.TonsOfBlocks.Main;
import net.frozenblock.api.server.block.ConnectedBlock;
import net.frozenblock.api.server.block.VerticalConnectedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

    //public static final ConnectedBlock CONNECTED_BLOCK = new ConnectedBlock(FabricBlockSettings.of(Material.STONE));
    public static final VerticalConnectedBlock VERTICAL_CONNECTED_BLOCK = new VerticalConnectedBlock(FabricBlockSettings.of(Material.STONE));

    public static final VerticalConnectedBlock FANCY_BIRCH_PLANKS = new VerticalConnectedBlock(FabricBlockSettings.of(Material.WOOD));

    public static void registerBlocks() {
        //registerNewBlock(new Identifier(Main.MODID,"connected_block"), CONNECTED_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
        registerNewBlock(new Identifier(Main.MODID,"vertical_connected_block"), VERTICAL_CONNECTED_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));

        //registerNewBlock(new Identifier(Main.MODID,"fancy_birch_planks"), FANCY_BIRCH_PLANKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    }

    private static void registerNewBlock(Identifier id, Block block, Item.Settings settings) {
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, settings));
    }
}
