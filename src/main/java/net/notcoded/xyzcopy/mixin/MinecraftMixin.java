package net.notcoded.xyzcopy.mixin;

import net.minecraft.client.Minecraft;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModClothConfig;
import net.notcoded.xyzcopy.config.ModConfig;
import net.notcoded.xyzcopy.util.LocationUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "tick()V", at = @At("TAIL"))
    private void tick(CallbackInfo ci) {
        ModConfig config = XYZCopy.config;
        if(config == null) return;

        while(XYZCopy.copyBlockKeybind.consumeClick() && !config.block.useKeybindWithF3) {
            LocationUtil.copyBlockLocation();
        }

        while(XYZCopy.copyLocationKeybind.consumeClick() && !config.location.useKeybindWithF3) {
            LocationUtil.copyLocation();
        }

        while(XYZCopy.openConfigKeybind.consumeClick()) {
            Minecraft.getInstance().setScreen(ModClothConfig.buildScreen(Minecraft.getInstance().screen));
        }
    }
}
