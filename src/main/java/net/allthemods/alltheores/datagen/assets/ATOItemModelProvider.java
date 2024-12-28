package net.allthemods.alltheores.datagen.assets;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.client.model.generators.loaders.DynamicFluidContainerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion;

public class ATOItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {

    public ATOItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Reference.MOD_ID, fileHelper);
    }

    private ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, ITEM_FOLDER + "/" + name);
    }

    @Override
    protected void registerModels() {
        ResourceLocation generated = ResourceLocation.withDefaultNamespace("item/generated");

        ATORegistry.ITEMS.getEntries().stream()
                .filter(item -> !(item.get() instanceof BlockItem))
                .forEach(item -> {
                    String name = item.getId().getPath();
                    if (!name.contains("bucket")) {
                        withExistingParent(name, generated)
                                .texture("layer0", res(name));

                    }
                });

        ATOSetHelper.applyToFluid(group -> withExistingParent(group.MOLTEN_BUCKET.getId().getPath(), ResourceLocation.fromNamespaceAndPath(NeoForgeVersion.MOD_ID, "item/bucket_drip"))
                .customLoader(DynamicFluidContainerModelBuilder::begin)
                .fluid(group.MOLTEN.get()));
    }
}
