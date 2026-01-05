//? if fabric {
package net.notcoded.xyzcopy.platforms.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.notcoded.xyzcopy.config.ModClothConfig;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ModClothConfig::buildScreen;
    }
}
//?}
