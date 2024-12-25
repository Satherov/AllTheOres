package net.allthemods.alltheores.content.blocks.sets;

import net.allthemods.alltheores.content.blocks.sets.ato_sets.*;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaDebrisSet;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaGemSet;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaIngotSet;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaSet;

import java.util.function.Consumer;

public class ATOSetHelper {

    public static void applyToAll(Consumer<BlockSet> consumer) {
        BlockSet.getSets().forEach(consumer);
    }

    public static void applyToOre(Consumer<ATOOreSet> consumer) {
        ATOOreSet.getOreSets().forEach(consumer);
    }

    public static void applyToMaterial(Consumer<ATOMaterialSet> consumer) {
        ATOMaterialSet.getMaterialSets().forEach(consumer);
    }

    public static void applyToAlloy(Consumer<ATOAlloySet> consumer) {
        ATOAlloySet.getAlloySets().forEach(consumer);
    }

    public static void applyToIngot(Consumer<ATOIngotSet> consumer) {
        ATOIngotSet.getIngotSets().forEach(consumer);
    }

    public static void applyToGem(Consumer<ATOGemSet> consumer) {
        ATOGemSet.getGemSets().forEach(consumer);
    }

    public static void applyToDust(Consumer<ATODustSet> consumer) {
        ATODustSet.getDustSets().forEach(consumer);
    }

    public static void applyToVanilla(Consumer<VanillaSet> consumer) {
        VanillaSet.getVanillaSets().forEach(consumer);
    }

    public static void applyToVanillaIngot(Consumer<VanillaIngotSet> consumer) {
        VanillaIngotSet.getVanillaIngotSets().forEach(consumer);
    }

    public static void applyToVanillaGem(Consumer<VanillaGemSet> consumer) {
        VanillaGemSet.getVanillaGemSets().forEach(consumer);
    }

    public static void applyToVanillaDebris(Consumer<VanillaDebrisSet> consumer) {
        VanillaDebrisSet.getVanillaDebrisSets().forEach(consumer);
    }

    public static void applyToMekanism(Consumer<MekanismSet> consumer) {
        MekanismSet.getMekanismSets().forEach(consumer);
    }

    public static void applyToFluid(Consumer<ATOFluidSet> consumer) {
        ATOFluidSet.getFluidSets().forEach(consumer);
    }
}
