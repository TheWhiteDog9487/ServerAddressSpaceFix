package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.multiplayer.ServerData;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.thewhitedog9487.Settings;

@Mixin(JoinMultiplayerScreen.class)
public class JoinMultiplayerScreenMixin {
    @Shadow public ServerData editingServer;

    @Inject(
            method = "directJoinCallback",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/ServerList;get(Ljava/lang/String;)Lnet/minecraft/client/multiplayer/ServerData;",
                    shift = At.Shift.BEFORE ) )
    private void onDirectJoinCallback(boolean result, CallbackInfo ci) {
        if ( Settings.ModEnabled == false ) { return; }
        else {
            this.editingServer = new ServerData(
                    this.editingServer.name,
                    this.editingServer.ip.replace(" ", ""),
                    this.editingServer.type() ); } } }