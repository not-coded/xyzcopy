//? if neoforge {
/*package net.notcoded.xyzcopy.platforms.neoforge;

import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;
//? if <1.20.6 {
import net.neoforged.neoforge.client.ConfigScreenHandler;
//?} else {
/^import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
^///?}
@Mod("xyzcopy")
public class XYZCopyNeoForge {
	public XYZCopyNeoForge() {
        ModLoadingContext.get().registerExtensionPoint(
                //? if <1.20.6 {
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        ((client, parent) -> ModClothConfig.buildScreen(parent))
                )
                //?} else {
                /^IConfigScreenFactory.class,
                () -> (client, parent) -> ModClothConfig.buildScreen(parent)
                ^///?}
        );
	}

    public static class NeoForgePlatform implements ModPlatform {
        @Override
        public String getModLoader() {
            return "NeoForge";
        }

        @Override
        public boolean isModLoaded(String modId) {
            return ModList.get().isLoaded(modId);
        }

        @Override
        public boolean isDevelopmentEnvironment() {
            return !FMLLoader.isProduction();
        }
    }
}
*///?}