package xyz.thewhitedog9487;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static xyz.thewhitedog9487.ServerAddressSpaceFix.ModID;

public class ServerAddressSpaceFixClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
//		LOGGER.info("ServerAddressSpaceFix Loading!");
	}
}