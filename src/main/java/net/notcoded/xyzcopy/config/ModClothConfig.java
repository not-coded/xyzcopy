package net.notcoded.xyzcopy.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.notcoded.xyzcopy.XYZCopy;
import net.notcoded.xyzcopy.util.VersionUtil;

@Config(name = "xyzcopy")
public class ModClothConfig extends ModConfig implements ConfigData {

    public static Screen buildScreen(Screen parent) {
        ModConfig config = XYZCopy.config;

        ConfigBuilder builder = ConfigBuilder.create();
        builder.setParentScreen(parent);
        builder.setTitle(getText("title"));
        builder.setDoesConfirmSave(false);

        builder.setSavingRunnable(() -> AutoConfig.getConfigHolder(ModClothConfig.class).save());

        ConfigCategory category = builder.getOrCreateCategory(getText("title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        category.addEntry(entryBuilder.startBooleanToggle(getText("replaceDebugKey"), config.replaceDebugKey)
                .setDefaultValue(true)
                .setTooltip(getText("replaceDebugKey.tooltip"))
                .setSaveConsumer(value -> config.replaceDebugKey = value)
                .build());

        category.addEntry(entryBuilder.startStrField(getText("locationTemplate"), config.locationTemplate)
                .setDefaultValue("%x %y %z in %dimension")
                .setTooltip(getText("locationTemplate.tooltip"), getText("locationTemplate.tooltip2"))
                .setSaveConsumer(value -> config.locationTemplate = value)
                .build());

        category.addEntry(entryBuilder.startIntSlider(getText("decimalPlaces"), config.decimalPlaces, 0, 17)
                .setDefaultValue(0)
                .setTooltip(getText("decimalPlaces.tooltip"))
                .setSaveConsumer(value -> config.decimalPlaces = value)
                .build());

        category.addEntry(entryBuilder.startBooleanToggle(getText("sendInChatInsteadOfCopyingToClipboard"), config.sendInChatInsteadOfCopyingToClipboard)
                .setDefaultValue(false)
                .setTooltip(getText("sendInChatInsteadOfCopyingToClipboard.tooltip"))
                .setSaveConsumer(value -> config.sendInChatInsteadOfCopyingToClipboard = value)
                .build());

        category.addEntry(entryBuilder.startStrField(getText("copyMessage"), config.copyMessage)
                .setDefaultValue("Copied location")
                .setTooltip(getText("copyMessage.tooltip"))
                .setSaveConsumer(value -> config.copyMessage = value)
                .build());

        category.addEntry(entryBuilder.startStrField(getText("copyMessageClipboard"), config.copyMessageClipboard)
                .setDefaultValue("debug.copy_location.message")
                .setTooltip(getText("copyMessageClipboard.tooltip"))
                .setSaveConsumer(value -> config.copyMessageClipboard = value)
                .build());

        return builder.build();
    }

    private static Component getText(String key) {
        return VersionUtil.getTranslatableText("xyzcopy.option." + key);
    }
}
