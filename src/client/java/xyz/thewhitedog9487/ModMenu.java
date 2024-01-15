package xyz.thewhitedog9487;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.text.Text;

public class ModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("title.thewhitedog9487.twd-sasf.config"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("config.thewhitedog9487.twd-sasf.category.general"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("option.thewhitedog9487.twd-sasf.ModEnabled"))
                                .binding(true, () -> Settings.ModEnabled, newVal -> Settings.ModEnabled = newVal)
                                .description(OptionDescription.of(Text.translatable("option.thewhitedog9487.twd-sasf.ModEnabled.description")))
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build())
                .build().generateScreen(parent);}}