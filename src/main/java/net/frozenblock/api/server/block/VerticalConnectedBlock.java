package net.frozenblock.api.server.block;

import net.frozenblock.api.server.properties.FrozenBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VerticalConnectedBlock extends Block {

    public static final BooleanProperty CONNECTED_UP;
    public static final BooleanProperty CONNECTED_DOWN;

    public VerticalConnectedBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(CONNECTED_UP, false)
                .with(CONNECTED_DOWN, false)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        return this.getDefaultState()
                .with(CONNECTED_UP, world.getBlockState(pos.up()).getBlock() == this)
                .with(CONNECTED_DOWN, world.getBlockState(pos.down()).getBlock() == this);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient) {
            world.setBlockState(pos, state
                    .with(CONNECTED_UP, world.getBlockState(pos.up()).getBlock() == this)
                    .with(CONNECTED_DOWN, world.getBlockState(pos.down()).getBlock() == this)
            );
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CONNECTED_DOWN, CONNECTED_UP);
    }

    static {
        CONNECTED_UP = FrozenBlockProperties.CONNECTED_UP;
        CONNECTED_DOWN = FrozenBlockProperties.CONNECTED_DOWN;
    }
}
