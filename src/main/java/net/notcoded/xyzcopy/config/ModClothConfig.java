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


        ConfigCategory locationCategory = builder.getOrCreateCategory(getText("category.location"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        locationCategory.addEntry(entryBuilder.startBooleanToggle(getText("replaceDebugKey"), config.location.replaceDebugKey)
                .setDefaultValue(true)
                .setTooltip(getText("replaceDebugKey.tooltip"), getText("replaceDebugKey.tooltip2"))
                .setSaveConsumer(value -> config.location.replaceDebugKey = value)
                .build());

        locationCategory.addEntry(entryBuilder.startBooleanToggle(getText("useKeybindWithF3"), config.location.useKeybindWithF3)
                .setDefaultValue(false)
                .setTooltip(getText("useKeybindWithF3.tooltip"), getText("useKeybindWithF3.tooltip2"))
                .setSaveConsumer(value -> config.location.useKeybindWithF3 = value)
                .build());

        locationCategory.addEntry(entryBuilder.startStrField(getText("locationTemplate"), config.location.locationTemplate)
                .setDefaultValue("%x %y %z")
                .setTooltip(getText("locationTemplate.tooltip"), getText("locationTemplate.tooltip2"))
                .setSaveConsumer(value -> config.location.locationTemplate = value)
                .build());

        locationCategory.addEntry(entryBuilder.startIntSlider(getText("decimalPlaces"), config.location.decimalPlaces, 0, 17)
                .setDefaultValue(0)
                .setTooltip(getText("decimalPlaces.tooltip"))
                .setSaveConsumer(value -> config.location.decimalPlaces = value)
                .build());

        locationCategory.addEntry(entryBuilder.startBooleanToggle(getText("sendInChatInsteadOfCopyingToClipboard"), config.location.sendInChatInsteadOfCopyingToClipboard)
                .setDefaultValue(false)
                .setTooltip(getText("sendInChatInsteadOfCopyingToClipboard.tooltip"))
                .setSaveConsumer(value -> config.location.sendInChatInsteadOfCopyingToClipboard = value)
                .build());

        locationCategory.addEntry(entryBuilder.startStrField(getText("copyMessage"), config.location.copyMessage)
                .setDefaultValue("Copied location")
                .setTooltip(getText("copyMessage.tooltip"), getText("copyMessage.tooltip2"), getText("copyMessage.tooltip3"))
                .setSaveConsumer(value -> config.location.copyMessage = value)
                .build());

        locationCategory.addEntry(entryBuilder.startStrField(getText("copyMessageClipboard"), config.location.copyMessageClipboard)
                .setDefaultValue("Copied location to clipboard")
                .setTooltip(getText("copyMessageClipboard.tooltip"), getText("copyMessageClipboard.tooltip2"))
                .setSaveConsumer(value -> config.location.copyMessageClipboard = value)
                .build());




        ConfigCategory blockCategory = builder.getOrCreateCategory(getText("category.block"));

        blockCategory.addEntry(entryBuilder.startBooleanToggle(getText("useKeybindWithF3"), config.block.useKeybindWithF3)
                .setDefaultValue(false)
                .setTooltip(getText("useKeybindWithF3.tooltip"), getText("useKeybindWithF3.tooltip2"))
                .setSaveConsumer(value -> config.block.useKeybindWithF3 = value)
                .build());

        blockCategory.addEntry(entryBuilder.startStrField(getText("block.locationTemplate"), config.block.locationTemplate)
                .setDefaultValue("%block at %x %y %z")
                .setTooltip(getText("block.locationTemplate.tooltip"), getText("block.locationTemplate.tooltip2"))
                .setSaveConsumer(value -> config.block.locationTemplate = value)
                .build());

        blockCategory.addEntry(entryBuilder.startBooleanToggle(getText("block.includeFluids"), config.block.includeFluids)
                .setDefaultValue(false)
                .setTooltip(getText("block.includeFluids.tooltip"))
                .setSaveConsumer(value -> config.block.includeFluids = value)
                .build());

        blockCategory.addEntry(entryBuilder.startBooleanToggle(getText("block.sendInChatInsteadOfCopyingToClipboard"), config.block.sendInChatInsteadOfCopyingToClipboard)
                .setDefaultValue(false)
                .setTooltip(getText("block.sendInChatInsteadOfCopyingToClipboard.tooltip"))
                .setSaveConsumer(value -> config.block.sendInChatInsteadOfCopyingToClipboard = value)
                .build());

        blockCategory.addEntry(entryBuilder.startStrField(getText("block.copyMessage"), config.block.copyMessage)
                .setDefaultValue("Copied block location")
                .setTooltip(getText("block.copyMessage.tooltip"), getText("block.copyMessage.tooltip2"), getText("block.copyMessage.tooltip3"))
                .setSaveConsumer(value -> config.block.copyMessage = value)
                .build());

        blockCategory.addEntry(entryBuilder.startStrField(getText("block.copyMessageClipboard"), config.block.copyMessageClipboard)
                .setDefaultValue("Copied block location to clipboard")
                .setTooltip(getText("block.copyMessageClipboard.tooltip"), getText("block.copyMessageClipboard.tooltip2"))
                .setSaveConsumer(value -> config.block.copyMessageClipboard = value)
                .build());

        return builder.build();
    }

    private static Component getText(String key) {
        return VersionUtil.getTranslatableText("xyzcopy.option." + key);
    }
}
