package xyz.thewhitedog9487;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.thewhitedog9487.Event.ClientLifecycleEventsRegister;

public class ServerAddressSpaceFixClient implements ClientModInitializer {
	public static final String ModID = "serveraddressspacefix";
	public static final Logger ModLogger = LoggerFactory.getLogger(ModID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientLifecycleEventsRegister.Register();
	}
}