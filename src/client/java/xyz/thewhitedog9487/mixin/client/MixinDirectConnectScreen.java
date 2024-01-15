package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.thewhitedog9487.Settings;

@Mixin(net.minecraft.client.gui.screen.multiplayer.DirectConnectScreen.class)
public class MixinDirectConnectScreen {
    @Redirect(method = "saveAndClose", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;getText()Ljava/lang/String;"))
    private String trimGetText(TextFieldWidget instance) {
        if( !Settings.ModEnabled ) { return instance.getText(); }
        String trimmedText = instance.getText().replace(" ", "");
        ((DirectConnectScreenAccessor) this).Mixin_GetAddressField().setText(trimmedText);
        return trimmedText;}}