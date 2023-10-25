package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.client.gui.screen.DirectConnectScreen.class)
public class MixinDirectConnectScreen {
    @Redirect(method = "saveAndClose", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;getText()Ljava/lang/String;"))
    private String trimGetText(TextFieldWidget instance) {
        String trimmedText = instance.getText().trim();
        ((DirectConnectScreenAccessor) this).Mixin_GetAddressField().setText(trimmedText);
        return trimmedText;
    }
}
