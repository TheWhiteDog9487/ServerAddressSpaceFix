package xyz.thewhitedog9487;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerAddressSpaceFixClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("twd-sasf");
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("ServerAddressSpaceFix正在初始化!");
	}
}