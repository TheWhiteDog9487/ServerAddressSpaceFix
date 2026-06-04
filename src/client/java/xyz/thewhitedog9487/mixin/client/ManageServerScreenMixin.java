package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ManageServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.ModLogger;
import static xyz.thewhitedog9487.Settings.SettingsInstance;

@Mixin(ManageServerScreen.class)
public class ManageServerScreenMixin {

    @Redirect(
            method = "onAdd",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/components/EditBox;getValue()Ljava/lang/String;",
                    ordinal = 1 ) )
    private String RedirectIpEditGetValue(EditBox instance) {
        var RawValue = instance.getValue();
        if ( SettingsInstance.ModEnabled == false ||
                RawValue.contains(" ") == false) {
            return RawValue; }
        else {
            var NewValue = RawValue.replace(" ", "");
            ModLogger.info("已完成移除空格替换！" + "\n" +
                    "原始值：" + RawValue + "\n" +
                    "新值：" + NewValue);
            return NewValue; } } }