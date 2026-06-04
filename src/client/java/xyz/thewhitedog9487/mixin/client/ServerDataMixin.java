package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.multiplayer.ServerData;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.ModLogger;
import static xyz.thewhitedog9487.Settings.SettingsInstance;

@Mixin(ServerData.class)
public class ServerDataMixin {
    /**
     * 用于处理服务器列表内已经存在的服务器项的IP存在空格的问题
     */
    @Redirect(method = "<init>", at = @At(value = "FIELD", opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/multiplayer/ServerData;ip:Ljava/lang/String;"))
    private void RemoveSpace_Write(ServerData original, String value) {
        @Nullable String RawValue = value;
        if (SettingsInstance.ModEnabled == false ||
                RawValue.contains(" ") == false) {
            original.ip = value;
            return; }
        else {
            var NewValue = RawValue.replace(" ", "");
            original.ip = NewValue;
            ModLogger.info("已完成移除空格替换！" + "\n" +
                    "原始值：" + RawValue + "\n" +
                    "新值：" + NewValue); } } }