package net.allthemods.alltheores.content.blocks.sets;

import java.util.ArrayList;
import java.util.List;

public class BlockSet {

    public final String name;

    private static final List<BlockSet> instances = new ArrayList<>();

    public static List<BlockSet> getSets() {
        return instances;
    }

    public BlockSet(String name) {
        this.name = name;
        instances.add(this);
    }

}
