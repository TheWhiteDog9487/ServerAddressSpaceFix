package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.screen.DirectConnectScreen.class)
public class MixinDirectConnectScreen extends Screen {
    protected MixinDirectConnectScreen(Text title) {
        super(title);}

    @Inject(method = "saveAndClose()V", at = @At("RETURN"))
    private void addAndClose(CallbackInfo ci){
    var ServerEntry = ((DirectConnectScreenAccessor) this).Mixin_GetServerEntry();
    var Address = ((DirectConnectScreenAccessor) this).Mixin_GetAddressField().getText();
    // this.serverEntry.address = this.addressField.getText();
    ServerEntry.address = Address.trim();}

}
