package net.allthemods.alltheores.datagen.assets;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ATOLanguageProvider extends LanguageProvider {
    public ATOLanguageProvider(PackOutput output, String locale) {
        super(output, Reference.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.alltheores", "All The Ores");
    }

    protected String format(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
