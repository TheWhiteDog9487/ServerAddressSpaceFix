package xyz.thewhitedog9487.mixin.client;

import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(net.minecraft.client.gui.screen.AddServerScreen.class)
public interface AddServerScreenAccessor {
    @Accessor("server")
    ServerInfo Mixin_GetServer();

    @Accessor("addressField")
    TextFieldWidget Mixin_GetAddressField();
}
