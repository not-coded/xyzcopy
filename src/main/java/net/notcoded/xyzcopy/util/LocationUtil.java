package net.notcoded.xyzcopy.util;

import net.minecraft.client.Minecraft;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModConfig;

import java.util.Locale;

public class LocationUtil {

    public static String copyLocation() {
        ModConfig config = XYZCopy.config;

        String locationTemplate = config.locationTemplate;
        Minecraft client = Minecraft.getInstance();

        assert client.player != null;
        String format = "%." + config.decimalPlaces + "f";

        return locationTemplate
                .replace("%x", String.format(Locale.ROOT, format, client.player.getX()))
                .replace("%yaw", String.format(Locale.ROOT, format, VersionUtil.getYRot(client.player)))
                .replace("%y", String.format(Locale.ROOT, format, client.player.getY()))
                .replace("%z", String.format(Locale.ROOT, format, client.player.getZ()))
                .replace("%pitch", String.format(Locale.ROOT, format, VersionUtil.getXRot(client.player)))
                .replace("%dimension", VersionUtil.getLevel(client.player).dimension().location().toString());
    }

}
