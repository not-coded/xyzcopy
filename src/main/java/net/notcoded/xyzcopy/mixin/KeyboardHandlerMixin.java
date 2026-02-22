package net.notcoded.xyzcopy.mixin;


import net.minecraft.client.KeyboardHandler;
//? if >=1.21.9 {
/*import net.minecraft.client.Minecraft;
import net.minecraft.client.input.KeyEvent;
*///?}

//? if >=1.21.11 {
/*import net.minecraft.util.Util;
*///?} else {
import net.minecraft.Util;
import org.lwjgl.glfw.GLFW;
//?}
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.config.ModConfig;
import net.notcoded.xyzcopy.util.LocationUtil;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {
    @Shadow
    private long debugCrashKeyTime;

    //? if <1.21.9 {
    @Inject(method = "handleDebugKeys", at = @At("HEAD"), cancellable = true)
    private void debugKey(int i, CallbackInfoReturnable<Boolean> cir) {
    //?} elif >=1.21.9 {
    /*@Inject(method = "handleDebugKeys", at = @At("HEAD"), cancellable = true)
    private void debugKey(KeyEvent arg, CallbackInfoReturnable<Boolean> cir) {
        int i = arg.key();
    *///?}
        if (this.debugCrashKeyTime > 0L && this.debugCrashKeyTime < Util.getMillis() - 100L) return;
        ModConfig config = XYZCopy.config;

        if(XYZCopy.config.location.useKeybindWithF3 && i == XYZCopy.copyLocationKeybind.key.getValue()) {
            cir.setReturnValue(true);
            LocationUtil.copyLocation();
            return;
        }

        if(XYZCopy.config.block.useKeybindWithF3 && i == XYZCopy.copyBlockKeybind.key.getValue()) {
            cir.setReturnValue(true);
            LocationUtil.copyBlockLocation();
            return;
        }

        //? if >=1.21.11 {
        /*boolean f3CKey = Minecraft.getInstance().options.keyDebugCopyLocation.matches(arg);
        *///?} else {
        boolean f3CKey = i == GLFW.GLFW_KEY_C;
        //?}

        if(f3CKey && config.location.replaceDebugKey) {
            cir.setReturnValue(true);
            LocationUtil.copyLocation();
            return;
        }
    }
}
