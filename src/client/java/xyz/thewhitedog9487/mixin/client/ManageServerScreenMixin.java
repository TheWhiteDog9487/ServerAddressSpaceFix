package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ManageServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.thewhitedog9487.Settings;

@Mixin(ManageServerScreen.class)
public class ManageServerScreenMixin {

    @Redirect(
            method = "onAdd",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/components/EditBox;getValue()Ljava/lang/String;",
                    ordinal = 1 ) )
    private String redirectIpEditGetValue(EditBox instance) {
        if ( Settings.ModEnabled == false ) {
            return instance.getValue(); }
        else {
            return instance.getValue()
                    .replace(" ", ""); } } }