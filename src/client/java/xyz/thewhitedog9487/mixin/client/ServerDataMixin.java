package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.multiplayer.ServerData;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.thewhitedog9487.Settings;

@Mixin(ServerData.class)
public class ServerDataMixin {
    @Redirect(method = "<init>", at = @At(value = "FIELD", opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/client/multiplayer/ServerData;ip:Ljava/lang/String;"))
    private void RemoveSpace_Write(ServerData original, String value) {
        if( Settings.ModEnabled == false ) {
            original.ip = value;
            return; }
        else {
            original.ip = value.replace(" ", ""); } } }