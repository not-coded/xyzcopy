package net.notcoded.xyzcopy.util;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

//? if <1.19 {
import net.minecraft.network.chat.TranslatableComponent;
//?}

public class VersionUtil {
    public static float getYRot(LocalPlayer player) {
        //? if 1.16.5 {
        return player.yRot;
        //?} elif >1.16.5 {
        /*return player.getYRot();
        *///?}
    }

    public static float getXRot(LocalPlayer player) {
        //? if 1.16.5 {
        return player.xRot;
        //?} elif >1.16.5 {
        /*return player.getXRot();
         *///?}
    }

    public static Level getLevel(LocalPlayer player) {
        //? if >=1.20 {
        /*return player.level();
         *///?} elif <1.20 {
        return player.level;
        //?}
    }

    public static Component getTranslatableText(String key) {
        //? if >=1.19 {
        /*return Component.translatable(key);
         *///?} elif <1.19 {
        return new TranslatableComponent(key);
        //?}
    }
}
