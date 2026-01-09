package net.notcoded.xyzcopy.mixin;

import net.minecraft.Util;
import net.minecraft.client.KeyboardHandler;
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
    public abstract void setClipboard(String string);

    @Shadow
    protected abstract void debugFeedbackTranslated(String string, Object... objects);

    @Shadow
    private long debugCrashKeyTime;

    @Inject(method = "handleDebugKeys", at = @At("HEAD"), cancellable = true)
    private void debugKey(int i, CallbackInfoReturnable<Boolean> cir) {
        if (this.debugCrashKeyTime > 0L && this.debugCrashKeyTime < Util.getMillis() - 100L) return;

        ModConfig config = XYZCopy.config;
        if(!config.replaceDebugKey) return;

        if(i == 67) { // C key
            cir.setReturnValue(false);

            String content = LocationUtil.copyLocation();

            if(config.sendInChatInsteadOfCopyingToClipboard) {
                this.debugFeedbackTranslated(config.copyMessage);
                //this.minecraft.gui.getChat().addMessage(new TranslatableComponent(content));
                this.debugFeedbackTranslated(content);
                this.setClipboard(content);
            } else {
                this.debugFeedbackTranslated(config.copyMessageClipboard);
                this.setClipboard(content);
            }
        }
    }
}
