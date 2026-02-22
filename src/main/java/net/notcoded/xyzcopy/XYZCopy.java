package net.notcoded.xyzcopy;

import com.mojang.blaze3d.platform.InputConstants;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.client.KeyMapping;
//? if 1.21.9 {
//import net.minecraft.resources.ResourceLocation;
//?} elif >=1.21.11 {
/*import net.minecraft.resources.Identifier;
*///?}
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.config.ModConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class XYZCopy {
    public static final Logger LOGGER = LogManager.getLogger(XYZCopy.class);
    public static ModConfig config;
    public static ModPlatform platform;

    //? if >=1.21.9 {
    /*public static final KeyMapping.Category category = new KeyMapping.Category(
            //? if 1.21.9 {
            //ResourceLocation
            //?} elif >=1.21.11 {
            /^Identifier
            ^///?}
                    .fromNamespaceAndPath("xyzcopy", "keybind")
    );
    *///?} else {
    private static final String category = "key.category.xyzcopy.keybind";
    //?}

    public static KeyMapping openConfigKeybind = new KeyMapping("xyzcopy.keybind.open_config", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, category);

    public static KeyMapping copyBlockKeybind = new KeyMapping("xyzcopy.keybind.copy_block", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, category);

    public static KeyMapping copyLocationKeybind = new KeyMapping("xyzcopy.keybind.copy_location", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, category);

    public static void init(ModPlatform platform) {
        AutoConfig.register(ModClothConfig.class, JanksonConfigSerializer::new);
        XYZCopy.config = AutoConfig.getConfigHolder(ModClothConfig.class).getConfig();
        XYZCopy.platform = platform;
    }

}