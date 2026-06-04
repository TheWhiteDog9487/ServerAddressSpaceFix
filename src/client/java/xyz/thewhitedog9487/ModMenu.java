package xyz.thewhitedog9487;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.network.chat.Component;

import static xyz.thewhitedog9487.Settings.SettingsInstance;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("title.serveraddressspacefix.config"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("config.serveraddressspacefix.category.general"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Component.translatable("option.serveraddressspacefix.ModEnabled"))
                                .binding(true, () -> SettingsInstance.ModEnabled, newVal -> {
                                    SettingsInstance.ModEnabled = newVal;
                                    Settings.SettingsHandler.save(); } )
                                .description(OptionDescription.of(Component.translatable("option.serveraddressspacefix.ModEnabled.description")))
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build())
                .build()
                .generateScreen(parent); } }