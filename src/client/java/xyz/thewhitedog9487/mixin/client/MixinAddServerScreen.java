package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.client.gui.screen.AddServerScreen.class)
public class MixinAddServerScreen {
    @Redirect(method = "addAndClose", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;getText()Ljava/lang/String;", ordinal = 1))
    private String trimGetText(TextFieldWidget instance) {
        return instance.getText().trim();
    }
}
