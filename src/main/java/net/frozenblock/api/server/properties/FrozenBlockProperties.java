package net.frozenblock.api.server.properties;

import net.minecraft.state.property.BooleanProperty;

public class FrozenBlockProperties {
    public static final String CONNECTION_PROPERTY = "connected_";
    public static final BooleanProperty CONNECTED_UP = BooleanProperty.of(CONNECTION_PROPERTY + "up");
    public static final BooleanProperty CONNECTED_DOWN = BooleanProperty.of(CONNECTION_PROPERTY + "down");
    public static final BooleanProperty CONNECTED_NORTH = BooleanProperty.of(CONNECTION_PROPERTY + "north");
    public static final BooleanProperty CONNECTED_SOUTH = BooleanProperty.of(CONNECTION_PROPERTY + "south");
    public static final BooleanProperty CONNECTED_WEST = BooleanProperty.of(CONNECTION_PROPERTY + "west");
    public static final BooleanProperty CONNECTED_EAST = BooleanProperty.of(CONNECTION_PROPERTY + "east");
}
