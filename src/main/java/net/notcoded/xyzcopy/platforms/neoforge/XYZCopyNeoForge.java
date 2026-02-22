//? if neoforge {
/*package net.notcoded.xyzcopy.platforms.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;
//? if <1.20.6 {
import net.neoforged.neoforge.client.ConfigScreenHandler;
//?} else {
/^import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
^///?}
@Mod("xyzcopy")
@OnlyIn(Dist.CLIENT)
public class XYZCopyNeoForge {
	public XYZCopyNeoForge(IEventBus modEventBus) {
        modEventBus.addListener(XYZCopyNeoForge::onClientSetup);
        modEventBus.addListener(XYZCopyNeoForge::registerBindings);
	}

    public static void onClientSetup(final FMLClientSetupEvent event) {
        XYZCopy.init(new NeoForgePlatform());

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

    public static void registerBindings(RegisterKeyMappingsEvent event) {
        //? if >=1.21.9 {
        /^event.registerCategory(XYZCopy.category);
        ^///?}

        event.register(XYZCopy.openConfigKeybind);
        event.register(XYZCopy.copyBlockKeybind);
        event.register(XYZCopy.copyLocationKeybind);
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
            //? if >=1.21.9 {
            /^return !FMLLoader.getCurrent().isProduction();
            ^///?} else {
            return !FMLLoader.isProduction();
            //?}
        }
    }
}
*///?}