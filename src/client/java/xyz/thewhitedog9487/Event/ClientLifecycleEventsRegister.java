package xyz.thewhitedog9487.Event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import xyz.thewhitedog9487.Settings;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.ModLogger;
import static xyz.thewhitedog9487.Settings.SettingsInstance;

public class ClientLifecycleEventsRegister {
    public static void Register(){
        ClientLifecycleEvents.CLIENT_STARTED.register(ClientInstance -> {
            ModLogger.info("正在从" + Settings.ConfigFilePath + "加载设置...");
            Settings.SettingsHandler.load();
            SettingsInstance = Settings.SettingsHandler.instance();
            Settings.RegisterConfigFileReloadWatcher(); } );
        ClientLifecycleEvents.CLIENT_STOPPING.register(ClientInstance -> {
            ModLogger.info("正在保存设置到" + Settings.ConfigFilePath + "...");
            Settings.SettingsHandler.save(); } ); } }