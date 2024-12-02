package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.registry.groups.*;

import java.util.function.Consumer;

public class GroupHelper {

    public static void applyToOre(Consumer<RegistryGroupOre> consumer) {
        RegistryGroupOre.getOreInstances().forEach(consumer);
    }

    public static void applyToAlloy(Consumer<RegistryGroupAlloy> consumer) {
        RegistryGroupAlloy.getAlloyInstances().forEach(consumer);
    }

    public static void applyToMaterial(Consumer<RegistryGroupMaterial> consumer) {
        RegistryGroupMaterial.getMaterialInstances().forEach(consumer);
    }

    public static void applyToVanilla(Consumer<RegistryGroupVanilla> consumer) {
        RegistryGroupVanilla.getVanillaInstances().forEach(consumer);
    }
}
