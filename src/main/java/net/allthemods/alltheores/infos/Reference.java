package net.allthemods.alltheores.infos;


import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Reference {

    public static final String MOD_ID = "alltheores";
    public static boolean enableFluids = ModList.get().isLoaded("tconstruct") || !FMLLoader.isProduction();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(String.format("itemGroup.%s", Reference.MOD_ID)))
            .icon(() -> ATORegistry.ALUMINUM.ORES.STONE_ORE_BLOCK_ITEM.get().asItem().getDefaultInstance())
            .build()
    );

    public static ResourceLocation ato(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static ResourceLocation forge(String path) {
        return ResourceLocation.fromNamespaceAndPath("c", path);
    }

    public static ResourceLocation ore(String path) {
        return forge("ores/" + path);
    }

    public static ResourceLocation ores_in_ground(String path) {
        return forge("ores_in_ground/" + path);
    }

    public static ResourceLocation nugget(String path) {
        return forge("nuggets/" + path);
    }

    public static ResourceLocation ingot(String path) {
        return forge("ingots/" + path);
    }

    public static ResourceLocation gem(String path) {
        return forge("gems/" + path);
    }

    public static ResourceLocation raw_materials(String path) {
        return forge("raw_materials/" + path);
    }

    public static ResourceLocation block(String path) {
        return forge("storage_blocks/" + path);
    }

    public static ResourceLocation dust(String path) {
        return forge("dusts/" + path);
    }

    public static ResourceLocation plate(String path) {
        return forge("plates/" + path);
    }

    public static ResourceLocation gear(String path) {
        return forge("gears/" + path);
    }

    public static ResourceLocation rod(String path) {
        return forge("rods/" + path);
    }

    public static ResourceLocation crystal(String path) {
        return forge("crystals/" + path);
    }

    public static ResourceLocation shard(String path) {
        return forge("shards/" + path);
    }

    public static ResourceLocation clump(String path) {
        return forge("clumps/" + path);
    }

    public static ResourceLocation dirty_dust(String path) {
        return forge("dirty_dusts/" + path);
    }
}
