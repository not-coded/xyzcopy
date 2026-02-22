package net.notcoded.xyzcopy.util;

import net.minecraft.client.Minecraft;
//? if <1.19.4 {
import net.minecraft.core.Registry;
//?} elif >=1.19.4 {
/*import net.minecraft.core.registries.BuiltInRegistries;
*///?}
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModConfig;

import java.util.Locale;

public class LocationUtil {

    public static void copyLocation() {
        ModConfig config = XYZCopy.config;
        if(config == null) return;

        boolean sendInChat = config.location.sendInChatInsteadOfCopyingToClipboard;
        Minecraft client = Minecraft.getInstance();

        if(client.player == null) return;
        String format = "%." + config.location.decimalPlaces + "f";

        String locationTemplate = config.location.locationTemplate
                .replace("%x", String.format(Locale.ROOT, format, client.player.getX()))
                .replace("%yaw", String.format(Locale.ROOT, format, VersionUtil.getYRot(client.player)))
                .replace("%y", String.format(Locale.ROOT, format, client.player.getY()))
                .replace("%z", String.format(Locale.ROOT, format, client.player.getZ()))
                .replace("%pitch", String.format(Locale.ROOT, format, VersionUtil.getXRot(client.player)))

                .replace("%dimension",
                        VersionUtil.getLevel(client.player).dimension()
                                //? if >=1.21.11 {
                                /*.identifier()
                                *///?} else {
                                .location()
                                //?}
                                .toString()
                );

        if(sendInChat) {
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(config.location.copyMessage.replaceAll("&", "§")));
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(locationTemplate));
        } else {
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(config.location.copyMessageClipboard.replaceAll("&", "§")));
            client.keyboardHandler.setClipboard(locationTemplate);
        }
    }

    public static void copyBlockLocation() {
        ModConfig config = XYZCopy.config;
        if(config == null) return;

        boolean sendInChat = config.block.sendInChatInsteadOfCopyingToClipboard;
        Minecraft client = Minecraft.getInstance();

        if(client.player == null) return;

        float f3DebugRange = 20.0F; // the F3 Debug screen uses 20 block reach
        BlockHitResult hitResult = (BlockHitResult) client.player.pick(f3DebugRange, 0.0F, XYZCopy.config.block.includeFluids);
        if(hitResult == null || hitResult.getType() == null) return;
        if(hitResult.getType() != HitResult.Type.BLOCK) return;

        String block = null;

        if(XYZCopy.config.block.includeFluids) {
            FluidState fluidState = VersionUtil.getLevel(client.player).getFluidState(hitResult.getBlockPos());
            //? if <1.19.4 {
            block = String.valueOf(Registry.FLUID.getKey(fluidState.getType()));
            //?} elif >=1.19.4 {
            /*block = String.valueOf(BuiltInRegistries.FLUID.getKey(fluidState.getType()));
            *///?}
        }

        if(block == null || block.equals("minecraft:empty")) {
            BlockState blockState = VersionUtil.getLevel(client.player).getBlockState(hitResult.getBlockPos());
            //? if <1.19.4 {
            block = String.valueOf(Registry.BLOCK.getKey(blockState.getBlock()));
            //?} elif >=1.19.4 {
            /*block = String.valueOf(BuiltInRegistries.BLOCK.getKey(blockState.getBlock()));
            *///?}
        }

        String locationTemplate = config.block.locationTemplate
                .replace("%x", String.valueOf(hitResult.getBlockPos().getX()))
                .replace("%y", String.valueOf(hitResult.getBlockPos().getY()))
                .replace("%z", String.valueOf(hitResult.getBlockPos().getZ()))
                .replace("%block", block)
                .replace("%dimension", VersionUtil.getLevel(client.player).dimension()
                        //? if >=1.21.11 {
                        /*.identifier()
                        *///?} else {
                        .location()
                        //?}
                        .toString()
                );

        if(sendInChat) {
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(config.block.copyMessage.replaceAll("&", "§")));
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(locationTemplate));
        } else {
            client.gui.getChat().addMessage(VersionUtil.getTranslatableText(config.block.copyMessageClipboard.replaceAll("&", "§")));
            client.keyboardHandler.setClipboard(locationTemplate);
        }
    }
}
