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

//? if <1.19 {
import net.minecraft.network.chat.TranslatableComponent;
//?}

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

        category.addEntry(entryBuilder.startBooleanToggle(getText("test"), config.test)
                .setDefaultValue(true)
                .setTooltip(getText("test.tooltip"), getText("test.tooltip2"))
                .setSaveConsumer(value -> config.test = value)
                .build());

        return builder.build();
    }

    private static Component getText(String key) {
        //? if >=1.19 {
        /*return Component.translatable("xyzcopy.option." + key);
         *///?} elif <1.19 {
        return new TranslatableComponent("xyzcopy.option." + key);
        //?}
    }
}
