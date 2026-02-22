//? if forge {
/*package net.notcoded.xyzcopy.platforms.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;

//? if <1.21.6 {
/^import net.minecraftforge.eventbus.api.IEventBus;
^///?} else {
import net.minecraftforge.eventbus.api.bus.BusGroup;
//?}


//? if <1.20.6 {
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//?}

//? if >=1.19 {
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
//?} elif 1.18.2 {
/^import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.client.ClientRegistry;
^///?} elif 1.17.1 {
/^import net.minecraftforge.fmlclient.ConfigGuiHandler;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
^///?} elif 1.16.5 {
/^import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.client.registry.ClientRegistry;
^///?}

@Mod("xyzcopy")
@OnlyIn(Dist.CLIENT)
public class XYZCopyForge {
    //? if <1.20.6 {
    /^public XYZCopyForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(XYZCopyForge::onClientSetup);
        //? if >=1.19 {
        modEventBus.addListener(XYZCopyForge::registerBindings);
        //?}
    }
    ^///?} elif >=1.20.6 <1.21.6 {
    /^public XYZCopyForge(IEventBus modEventBus) {
        modEventBus.addListener(XYZCopyForge::onClientSetup);
        modEventBus.addListener(XYZCopyForge::registerBindings);
    }
    ^///?} elif >=1.21.6 {
    public XYZCopyForge(FMLJavaModLoadingContext context) {
        BusGroup modBusGroup = context.getModBusGroup();
        FMLClientSetupEvent.getBus(modBusGroup).addListener(XYZCopyForge::onClientSetup);
        RegisterKeyMappingsEvent.getBus(modBusGroup).addListener(XYZCopyForge::registerBindings);
    }
    //?}

    public static void onClientSetup(final FMLClientSetupEvent event) {
        setupConfigScreen();

        //? if <1.19 {
        /^ClientRegistry.registerKeyBinding(XYZCopy.openConfigKeybind);
        ClientRegistry.registerKeyBinding(XYZCopy.copyBlockKeybind);
        ClientRegistry.registerKeyBinding(XYZCopy.copyLocationKeybind);
        ^///?}


        XYZCopy.init(new ForgePlatform());
    }

    //? if >=1.19 {
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(XYZCopy.openConfigKeybind);
        event.register(XYZCopy.copyBlockKeybind);
        event.register(XYZCopy.copyLocationKeybind);
    }
    //?}


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
}*/