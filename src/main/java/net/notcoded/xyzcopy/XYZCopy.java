package net.notcoded.xyzcopy;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.config.ModConfig;
import net.notcoded.xyzcopy.platforms.ModPlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XYZCopy {
    public static final Logger LOGGER = LogManager.getLogger(XYZCopy.class);
    public static ModConfig config;
    public static ModPlatform platform;

    public static void init(ModPlatform platform) {
        AutoConfig.register(ModClothConfig.class, JanksonConfigSerializer::new);
        XYZCopy.config = AutoConfig.getConfigHolder(ModClothConfig.class).getConfig();
        XYZCopy.platform = platform;

        LOGGER.info("Hello World on {}!", platform.getModLoader());
    }
}