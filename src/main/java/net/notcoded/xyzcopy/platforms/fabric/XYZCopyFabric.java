//? if fabric {
package net.notcoded.xyzcopy.platforms.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.platforms.ModPlatform;

public class XYZCopyFabric implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
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