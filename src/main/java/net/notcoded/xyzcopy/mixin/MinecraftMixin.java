package net.notcoded.xyzcopy.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;

//? if neoforge {
/*import net.notcoded.xyzcopy.platforms.neoforge.XYZCopyNeoForge;
*///?}

//? if forge {
//import net.notcoded.xyzcopy.platforms.forge.XYZCopyForge;
//?}

@Mixin(Minecraft.class)
public class MinecraftMixin {

    //? if forge || neoforge {
    /*@Inject(method = "<clinit>", at = @At("HEAD"))
    private static void initMod(CallbackInfo ci) {
        ModPlatform platform;

        //? if neoforge {
        /^platform = new XYZCopyNeoForge.NeoForgePlatform();
        ^///?}

        //? if forge {
        /^platform = new XYZCopyForge.ForgePlatform();
        ^///?}

        WayFix.init(platform);
    }
    *///?}
}
