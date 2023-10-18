package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.AddServerScreen.class)
public class MixinAddServerScreen extends Screen {
    protected MixinAddServerScreen(Text title) {
        super(title);}

    @Inject(method = "addAndClose()V", at = @At("RETURN"))
    private void addAndClose(CallbackInfo ci){
        var Server = ((AddServerScreenAccessor) this).Mixin_GetServer();
        var Address = ((AddServerScreenAccessor) this).Mixin_GetAddressField().getText();
        // this.server.address = this.addressField.getText();
        Server.address = Address.trim();}

}
