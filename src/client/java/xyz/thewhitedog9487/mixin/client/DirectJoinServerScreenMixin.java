package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.DirectJoinServerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.ModLogger;
import static xyz.thewhitedog9487.Settings.SettingsInstance;

@Mixin(DirectJoinServerScreen.class)
public class DirectJoinServerScreenMixin {
    @Shadow private EditBox ipEdit;

    @Inject(method = "init", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        RemoveSpaceCharacter(); }

    @Inject(method = "onSelect", at = @At("HEAD"))
    private void onSelect(CallbackInfo ci) {
        RemoveSpaceCharacter(); }

    @Inject(method = "removed", at = @At("HEAD"))
    private void onRemoved(CallbackInfo ci) {
        RemoveSpaceCharacter(); }

    @Unique
    private void RemoveSpaceCharacter() {
        var RawValue = ipEdit.getValue();
        if (SettingsInstance.ModEnabled == false ||
                RawValue.contains(" ") == false) { return; }
        var NewValue = RawValue.replace(" ", "");
        this.ipEdit.setValue(NewValue);
        ModLogger.info("已完成移除空格替换！" + "\n" +
                "原始值：" + RawValue + "\n" +
                "新值：" + NewValue); } }

