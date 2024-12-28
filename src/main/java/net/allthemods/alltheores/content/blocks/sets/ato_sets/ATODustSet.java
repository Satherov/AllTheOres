package net.allthemods.alltheores.content.blocks.sets.ato_sets;

import net.allthemods.alltheores.content.blocks.sets.ESetTypes;

import java.util.ArrayList;
import java.util.List;

public class ATODustSet extends ATOMaterialSet {

    private static final List<ATODustSet> instances = new ArrayList<>();

    public static List<ATODustSet> getDustSets() {
        return instances;
    }

    public final ATOOreSet ORES;

    public ATODustSet(String name, String hardness, int veinSize, int minY, int maxY, int count) {
        super(name, ESetTypes.DUST);
        instances.add(this);

        ORES = new ATOOreSet(name, ESetTypes.DUST, hardness, DUST, BLOCK, veinSize, minY, maxY, count);
    }
}
