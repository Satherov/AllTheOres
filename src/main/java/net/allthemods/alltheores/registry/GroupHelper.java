package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.registry.groups.*;

import java.util.function.Consumer;

public class GroupHelper {

    public static void applyToOre(Consumer<RegistryGroupOre> consumer) {
        applyToMaterial(group -> {
            consumer.accept(group.ORES);
        });
        applyToGem(group -> {
            consumer.accept(group.ORES);
        });
        applyToDust(group -> {
            consumer.accept(group.ORES);
        });
    }

    public static void applyToAlloy(Consumer<RegistryGroupAlloy> consumer) {
        RegistryGroupAlloy.getAlloyInstances().forEach(consumer);
    }

    public static void applyToMaterial(Consumer<RegistryGroupMaterial> consumer) {
        RegistryGroupMaterial.getMaterialInstances().forEach(consumer);
    }

    public static void applyToGem(Consumer<RegistryGroupGem> consumer) {
        RegistryGroupGem.getGemInstances().forEach(consumer);
    }

    public static void applyToDust(Consumer<RegistryGroupDust> consumer) {
        RegistryGroupDust.getDustInstances().forEach(consumer);
    }

    public static void applyToVanilla(Consumer<RegistryGroupVanilla> consumer) {
        RegistryGroupVanilla.getVanillaInstances().forEach(consumer);
    }
}
