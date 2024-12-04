package net.allthemods.alltheores;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ATOConfig {

    public static ATOConfig atoConfig;
    public final ATOConfig.Startup startup = new ATOConfig.Startup();

    public ATOConfig (ModContainer container) {
        container.registerConfig(ModConfig.Type.STARTUP, startup.spec);
    }

    public static void register(ModContainer container) {
        atoConfig = new ATOConfig(container);
    }

    public static class Startup{
        private final ModConfigSpec spec;

        public final ModConfigSpec.BooleanValue enableFluids;

        public Startup() {
            ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

            builder.push("general");

            enableFluids = builder.comment("Enable Molten Fluids").define("enableFluids", true);

            builder.pop();

            this.spec = builder.build();
        }
    }
}
