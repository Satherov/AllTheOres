package net.allthemods.alltheores.datagen.assets.lang;

import net.allthemods.alltheores.datagen.assets.ATOLanguageProvider;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.registry.GroupHelper;
import net.minecraft.data.PackOutput;

public class EN_USProvider extends ATOLanguageProvider {
    public EN_USProvider(PackOutput output) {
        super(output,"en_us");
    }

    @Override
    protected void addTranslations() {

        add(ATORegistry.COPPER_ORE_HAMMER.get(), "Copper Ore Hammer");
        add(ATORegistry.IRON_ORE_HAMMER.get(), "Iron Ore Hammer");
        add(ATORegistry.BRONZE_ORE_HAMMER.get(), "Bronze Ore Hammer");
        add(ATORegistry.INVAR_ORE_HAMMER.get(), "Invar Ore Hammer");
        add(ATORegistry.PLATINUM_ORE_HAMMER.get(), "Platinum Ore Hammer");

        GroupHelper.applyToOre( group -> {
            switch (group.type) {
                case "ingot" :
                    add(group.DROP.get(), String.format("Raw %s", format(group.name)));
                    add(group.DROP_BLOCK.get(), String.format("Raw %s Block", format(group.name)));
                    break;
                case "dust" :
                    add(group.DROP.get(), format(group.name));
                    add(group.DROP_BLOCK.get(), String.format("%s Block", format(group.name)));
                    break;
                case "gem" :
                    add(group.DROP.get(), format(group.name));
                    add(group.DUST.get(), String.format("%s Dust", format(group.name)));
                    add(group.DROP_BLOCK.get(), String.format("%s Block", format(group.name)));
                    break;
            }

            add(group.STONE_ORE_BLOCK.get(), String.format("%s Ore", format(group.name)));
            add(group.SLATE_ORE_BLOCK.get(), String.format("%s Deepslate Ore", format(group.name)));
            add(group.NETHER_ORE_BLOCK.get(), String.format("Nether %s Ore", format(group.name)));
            add(group.END_ORE_BLOCK.get(), String.format("End %s Ore", format(group.name)));
            add(group.OTHER_ORE_BLOCK.get(), String.format("Other %s Ore", format(group.name)));
        });

        GroupHelper.applyToAlloy( group -> {
            add(group.NUGGET.get(), String.format("%s Nugget", format(group.name)));
            add(group.INGOT.get(), String.format("%s Ingot", format(group.name)));
            add(group.BLOCK.get(), String.format("%s Block", format(group.name)));

            add(group.DUST.get(), String.format("%s Dust", format(group.name)));
            add(group.ROD.get(), String.format("%s Rod", format(group.name)));
            add(group.GEAR.get(), String.format("%s Gear", format(group.name)));
            add(group.PLATE.get(), String.format("%s Plate", format(group.name)));
        });

        GroupHelper.applyToVanilla( group -> {
            add(group.DUST.get(), String.format("%s Dust", format(group.name)));
            add(group.ROD.get(), String.format("%s Rod", format(group.name)));
            add(group.GEAR.get(), String.format("%s Gear", format(group.name)));
            add(group.PLATE.get(), String.format("%s Plate", format(group.name)));
        });

        GroupHelper.applyToMaterial( group -> {
            add(group.MOLTEN_BLOCK.get(), String.format("Molten %s", format(group.name)));
            add(group.MOLTEN_TYPE.get().getDescriptionId(), String.format("Molten %s", format(group.name)));
            add(group.MOLTEN_BUCKET.get(), String.format("Bucket of Molten %s", format(group.name)));
        });

        GroupHelper.applyToMekanism( group -> {
            add(group.CLEAN_SLURRY.get().getTranslationKey(), String.format("Clean %s Slurry", format(group.name)));
            add(group.DIRTY_SLURRY.get().getTranslationKey(), String.format("Dirty %s Slurry", format(group.name)));

            add(group.CRYSTAL.get(), String.format("%s Crystal", format(group.name)));
            add(group.SHARD.get(), String.format("%s Shard", format(group.name)));
            add(group.CLUMP.get(), String.format("%s Clump", format(group.name)));
            add(group.DIRTY_DUST.get(), String.format("Dirty %s Dust", format(group.name)));
        });
    }
}
