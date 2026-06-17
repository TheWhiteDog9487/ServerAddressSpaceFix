package xyz.thewhitedog9487.Event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import xyz.thewhitedog9487.Settings;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.ModLogger;
import static xyz.thewhitedog9487.Settings.*;

public class ClientLifecycleEventsRegister {
    public static void Register(){
        ClientLifecycleEvents.CLIENT_STARTED.register(ClientInstance -> {
            if (Settings.SettingsHandler == null){
                ModLogger.warn("当前没有安装YACL，因此无法调整和保持Mod配置");
                SettingsInstance = new Settings(); }
            else {
                ModLogger.info("正在从" + Settings.ConfigFilePath + "加载设置...");
                Settings.SettingsHandler.load();
                SettingsInstance = Settings.SettingsHandler.instance();
                if (SettingsInstance.ConfigurationVersionCode != CurrentConfigurationVersionCode){
                    // 必要时手动处理升降级，现在不必要，就这么办了
                    SettingsInstance.ConfigurationVersionCode = CurrentConfigurationVersionCode;
                    SettingsHandler.save(); }
                Settings.RegisterConfigFileReloadWatcher(); } } );
        ClientLifecycleEvents.CLIENT_STOPPING.register(ClientInstance -> {
            if (Settings.SettingsHandler == null) return;
            ModLogger.info("正在保存设置到" + Settings.ConfigFilePath + "...");
            Settings.SettingsHandler.save(); } ); } }