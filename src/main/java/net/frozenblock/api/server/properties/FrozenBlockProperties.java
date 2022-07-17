package net.frozenblock.api.server.properties;

import net.minecraft.state.property.BooleanProperty;

public class FrozenBlockProperties {
    public static final BooleanProperty CONNECTED_UP = BooleanProperty.of("connected_up");
    public static final BooleanProperty CONNECTED_DOWN = BooleanProperty.of("connected_down");
    public static final BooleanProperty CONNECTED_NORTH = BooleanProperty.of("connected_north");
    public static final BooleanProperty CONNECTED_SOUTH = BooleanProperty.of("connected_south");
    public static final BooleanProperty CONNECTED_WEST = BooleanProperty.of("connected_west");
    public static final BooleanProperty CONNECTED_EAST = BooleanProperty.of("connected_east");
}
