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

    // Properties for main Connections
    public static final BooleanProperty CONNECTED_UP;
    public static final BooleanProperty CONNECTED_DOWN;
    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_WEST;
    public static final BooleanProperty CONNECTED_EAST;

    // Properties for secondary Connections
    public static final BooleanProperty CONNECTED_UP_NORTH;
    public static final BooleanProperty CONNECTED_UP_SOUTH;
    public static final BooleanProperty CONNECTED_UP_WEST;
    public static final BooleanProperty CONNECTED_UP_EAST;
    public static final BooleanProperty CONNECTED_DOWN_NORTH;
    public static final BooleanProperty CONNECTED_DOWN_SOUTH;
    public static final BooleanProperty CONNECTED_DOWN_WEST;
    public static final BooleanProperty CONNECTED_DOWN_EAST;


    public ConnectedBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(CONNECTED_UP, false)
                .with(CONNECTED_DOWN, false)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_WEST, false)
                .with(CONNECTED_EAST, false)

                .with(CONNECTED_UP_NORTH, false)
                .with(CONNECTED_UP_SOUTH, false)
                .with(CONNECTED_UP_WEST, false)
                .with(CONNECTED_UP_EAST, false)

                .with(CONNECTED_DOWN_NORTH, false)
                .with(CONNECTED_DOWN_SOUTH, false)
                .with(CONNECTED_DOWN_WEST, false)
                .with(CONNECTED_DOWN_EAST, false)

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

        CONNECTED_UP_NORTH = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "up_north");
        CONNECTED_UP_SOUTH = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "up_south");
        CONNECTED_UP_WEST = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "up_west");
        CONNECTED_UP_EAST = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "up_east");

        CONNECTED_DOWN_NORTH = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "down_north");
        CONNECTED_DOWN_SOUTH = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "down_south");
        CONNECTED_DOWN_WEST = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "down_west");
        CONNECTED_DOWN_EAST = BooleanProperty.of(FrozenBlockProperties.CONNECTION_PROPERTY + "down_east");
    }
}
