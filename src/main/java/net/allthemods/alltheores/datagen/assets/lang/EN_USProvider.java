package net.allthemods.alltheores.datagen.assets.lang;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.datagen.assets.ATOLanguageProvider;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.data.PackOutput;

public class EN_USProvider extends ATOLanguageProvider {
    public EN_USProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.alltheores", "All The Ores");

        add(ATORegistry.COPPER_NUGGET.get(), "Copper Nugget");

        add(ATORegistry.COPPER_ORE_HAMMER.get(), "Copper Ore Hammer");
        add(ATORegistry.IRON_ORE_HAMMER.get(), "Iron Ore Hammer");
        add(ATORegistry.BRONZE_ORE_HAMMER.get(), "Bronze Ore Hammer");
        add(ATORegistry.INVAR_ORE_HAMMER.get(), "Invar Ore Hammer");
        add(ATORegistry.PLATINUM_ORE_HAMMER.get(), "Platinum Ore Hammer");

        ATOSetHelper.applyToOre(set -> {
            add(set.STONE_ORE_BLOCK.get(), String.format("%s Ore", format(set.name)));
            add(set.SLATE_ORE_BLOCK.get(), String.format("Deepslate %s Ore", format(set.name)));
            add(set.NETHER_ORE_BLOCK.get(), String.format("Nether %s Ore", format(set.name)));
            add(set.END_ORE_BLOCK.get(), String.format("End %s Ore", format(set.name)));
            add(set.OTHER_ORE_BLOCK.get(), String.format("Other %s Ore", format(set.name)));
        });

        ATOSetHelper.applyToMaterial(set -> add(set.BLOCK.get(), String.format("%s Block", format(set.name))));

        ATOSetHelper.applyToAlloy(set -> {
            add(set.NUGGET.get(), String.format("%s Nugget", format(set.name)));
            add(set.INGOT.get(), String.format("%s Ingot", format(set.name)));

            add(set.DUST.get(), String.format("%s Dust", format(set.name)));
            add(set.ROD.get(), String.format("%s Rod", format(set.name)));
            add(set.GEAR.get(), String.format("%s Gear", format(set.name)));
            add(set.PLATE.get(), String.format("%s Plate", format(set.name)));
        });

        ATOSetHelper.applyToIngot(set -> {
            add(set.RAW.get(), String.format("Raw %s", format(set.name)));
            add(set.RAW_BLOCK.get(), String.format("Raw %s Block", format(set.name)));
        });

        ATOSetHelper.applyToGem(set -> {
            add(set.GEM.get(), format(set.name));
            add(set.DUST.get(), String.format("%s Dust", format(set.name)));
        });

        ATOSetHelper.applyToDust(set -> add(set.DUST.get(), format(set.name)));

        ATOSetHelper.applyToVanilla(set -> {
            add(set.DUST.get(), String.format("%s Dust", format(set.name)));
            add(set.ROD.get(), String.format("%s Rod", format(set.name)));
            add(set.GEAR.get(), String.format("%s Gear", format(set.name)));
            add(set.PLATE.get(), String.format("%s Plate", format(set.name)));
        });

        ATOSetHelper.applyToMekanism(set -> {
            add(set.CLEAN_SLURRY.get().getTranslationKey(), String.format("Clean %s Slurry", format(set.name)));
            add(set.DIRTY_SLURRY.get().getTranslationKey(), String.format("Dirty %s Slurry", format(set.name)));

            add(set.CRYSTAL.get(), String.format("%s Crystal", format(set.name)));
            add(set.SHARD.get(), String.format("%s Shard", format(set.name)));
            add(set.CLUMP.get(), String.format("%s Clump", format(set.name)));
            add(set.DIRTY_DUST.get(), String.format("Dirty %s Dust", format(set.name)));
        });

        ATOSetHelper.applyToFluid(set -> {
            add(set.MOLTEN_BLOCK.get(), String.format("Molten %s", format(set.name)));
            add(set.MOLTEN_TYPE.get().getDescriptionId(), String.format("Molten %s", format(set.name)));
            add(set.MOLTEN_BUCKET.get(), String.format("Bucket of Molten %s", format(set.name)));
        });
    }
}
