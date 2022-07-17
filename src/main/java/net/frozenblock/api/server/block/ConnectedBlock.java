package net.frozenblock.api.server.block;

import net.frozenblock.api.server.properties.FrozenBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class ConnectedBlock extends Block {
    public static final BooleanProperty CONNECTED_UP;
    public static final BooleanProperty CONNECTED_DOWN;
    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_WEST;
    public static final BooleanProperty CONNECTED_EAST;

    public ConnectedBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(CONNECTED_UP, false)
                .with(CONNECTED_DOWN, false)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_WEST, false)
                .with(CONNECTED_EAST, false)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        return this.getDefaultState()
                .with(CONNECTED_UP, world.getBlockState(pos.up()).getBlock() == this)
                .with(CONNECTED_DOWN, world.getBlockState(pos.down()).getBlock() == this)
                .with(CONNECTED_NORTH, world.getBlockState(pos.north()).getBlock() == this)
                .with(CONNECTED_SOUTH, world.getBlockState(pos.south()).getBlock() == this)
                .with(CONNECTED_WEST, world.getBlockState(pos.west()).getBlock() == this)
                .with(CONNECTED_EAST, world.getBlockState(pos.east()).getBlock() == this);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if(!world.isClient) {
            world.setBlockState(pos, state
                    .with(CONNECTED_UP, world.getBlockState(pos.up()).getBlock() == this)
                    .with(CONNECTED_DOWN, world.getBlockState(pos.down()).getBlock() == this)
                    .with(CONNECTED_NORTH, world.getBlockState(pos.north()).getBlock() == this)
                    .with(CONNECTED_SOUTH, world.getBlockState(pos.south()).getBlock() == this)
                    .with(CONNECTED_WEST, world.getBlockState(pos.west()).getBlock() == this)
                    .with(CONNECTED_EAST, world.getBlockState(pos.east()).getBlock() == this)
            );
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CONNECTED_UP, CONNECTED_DOWN, CONNECTED_NORTH, CONNECTED_SOUTH, CONNECTED_WEST, CONNECTED_EAST);
    }

    static {
        CONNECTED_UP = FrozenBlockProperties.CONNECTED_UP;
        CONNECTED_DOWN = FrozenBlockProperties.CONNECTED_DOWN;
        CONNECTED_NORTH = FrozenBlockProperties.CONNECTED_NORTH;
        CONNECTED_SOUTH = FrozenBlockProperties.CONNECTED_SOUTH;
        CONNECTED_WEST = FrozenBlockProperties.CONNECTED_WEST;
        CONNECTED_EAST = FrozenBlockProperties.CONNECTED_EAST;
    }
}
