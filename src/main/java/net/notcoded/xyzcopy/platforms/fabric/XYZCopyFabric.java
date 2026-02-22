//? if fabric {
package net.notcoded.xyzcopy.platforms.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.impl.client.keybinding.KeyBindingRegistryImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.platforms.ModPlatform;

public class XYZCopyFabric implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
        if(FabricLoader.getInstance().isModLoaded("fabric-key-binding-api-v1")) {
            XYZCopy.openConfigKeybind = KeyBindingHelper.registerKeyBinding(XYZCopy.openConfigKeybind);
            XYZCopy.copyBlockKeybind = KeyBindingHelper.registerKeyBinding(XYZCopy.copyBlockKeybind);
            XYZCopy.copyLocationKeybind = KeyBindingHelper.registerKeyBinding(XYZCopy.copyLocationKeybind);
        }
		XYZCopy.init(new FabricPlatform());
	}

    public static class FabricPlatform implements ModPlatform {

        @Override
        public String getModLoader() {
            return "Fabric";
        }

        @Override
        public boolean isModLoaded(String modId) {
            return FabricLoader.getInstance().isModLoaded(modId);
        }

        @Override
        public boolean isDevelopmentEnvironment() {
            return FabricLoader.getInstance().isDevelopmentEnvironment();
        }
    }
}
//?}