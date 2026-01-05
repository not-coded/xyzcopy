//? if forge {
/*package net.notcoded.xyzcopy.platforms.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;

//? if >=1.19 {
import net.minecraftforge.client.ConfigScreenHandler;
//?} elif 1.18.2 {
/^import net.minecraftforge.client.ConfigGuiHandler;
^///?} elif 1.17.1 {
/^import net.minecraftforge.fmlclient.ConfigGuiHandler;
^///?} elif 1.16.5 {
/^import net.minecraftforge.fml.ExtensionPoint;
^///?}

@Mod("xyzcopy")
@OnlyIn(Dist.CLIENT)
public class XYZCopyForge {
	public XYZCopyForge() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ConfigScreen::setupConfigScreen);
	}

    public static class ForgePlatform implements ModPlatform {
        @Override
        public String getModLoader() {
            return "Forge";
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

class ConfigScreen {
    static void setupConfigScreen() {
        //? if >=1.19 {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory(
                        (client, parent) -> ModClothConfig.buildScreen(parent)
                )
        );
        //?} elif >1.16.5 <1.19 {
        /^ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory((client, parent) -> ModClothConfig.buildScreen(parent)
        ));
        ^///?} elif 1.16.5 {
        /^ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () ->
                (client, parent) -> ModClothConfig.buildScreen(parent)
        );
        ^///?}
    }
}
//?}*/