package net.allthemods.alltheores.blocks.mek_reg;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalBuilder;
import mekanism.common.registration.MekanismDeferredRegister;
import mekanism.common.registration.impl.DeferredChemical;
import mekanism.common.registration.impl.SlurryRegistryObject;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SlurryRegistry extends MekanismDeferredRegister<Chemical> {


    public SlurryRegistry(String modid) {
        super(MekanismAPI.CHEMICAL_REGISTRY_NAME,modid, DeferredChemical::new);
    }

    public SlurryRegistryObject<Chemical, Chemical> register(ATOResource resource) {
        return registera(resource.getRegistrySuffix(), builder -> builder.tint(resource.getTint()).ore(resource.getOreTag()));
    }

    public SlurryRegistryObject<Chemical, Chemical> registera(String baseName, UnaryOperator<ChemicalBuilder> builderModifier) {
        return new SlurryRegistryObject<>(register("dirty_" + baseName, () -> new Chemical(builderModifier.apply(ChemicalBuilder.dirtySlurry()))),
                register("clean_" + baseName, () -> new Chemical(builderModifier.apply(ChemicalBuilder.cleanSlurry()))));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <CHEM extends Chemical> DeferredChemical<CHEM> register(String name, Supplier<? extends CHEM> sup) {
        return (DeferredChemical<CHEM>) super.register(name, sup);
    }
}
