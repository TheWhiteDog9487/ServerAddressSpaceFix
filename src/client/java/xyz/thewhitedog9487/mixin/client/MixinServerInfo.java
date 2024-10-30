package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.network.ServerInfo;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.thewhitedog9487.Settings;

import java.nio.file.Paths;

@Mixin(ServerInfo.class)
public class MixinServerInfo {
    @Redirect(method = "<init>", at = @At(value = "FIELD", opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/network/ServerInfo;address:Ljava/lang/String;"))
    private void RemoveSpace_Write(ServerInfo original, String value) {
        if( Settings.ModEnabled == false ) {
            original.address = value;
            return; }
        else { original.address = value.replace(" ", ""); } }}