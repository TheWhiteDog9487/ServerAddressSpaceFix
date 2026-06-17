package xyz.thewhitedog9487;

import com.google.gson.GsonBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.*;

public class Settings {
    public static Path ConfigFilePath = FabricLoader.getInstance()
            .getConfigDir()
            .resolve(FriendlyModID + ".json5")
            .toAbsolutePath();
    public static ConfigClassHandler<Settings> SettingsHandler = null;
    public static long CurrentConfigurationVersionCode = 0;

    static {
        try {
            SettingsHandler = ConfigClassHandler.createBuilder(Settings.class)
                    .id(Identifier.fromNamespaceAndPath(ModID, "settings_confighandler"))
                    .serializer(SettingsConfigClassHandler -> GsonConfigSerializerBuilder.create(SettingsConfigClassHandler)
                            .setPath(ConfigFilePath)
                            .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
                            .setJson5(true)
                            .build() )
                    .build();
        } catch (NoClassDefFoundError _) {} }

    public static volatile Settings SettingsInstance;

//    region 配置文件变更监听器
    public static void RegisterConfigFileReloadWatcher(){
        // 由GPT 5.4 Mini生成
        Thread.startVirtualThread(new Thread(() -> {
            Path ConfigDirectory = ConfigFilePath.getParent();
            try (WatchService WatchService = FileSystems.getDefault().newWatchService()) {
                ConfigDirectory.register(WatchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
                while (!Thread.currentThread().isInterrupted()) {
                    WatchKey WatchKey = WatchService.take();
                    boolean ShouldReload = false;

                    for (WatchEvent<?> WatchEvent : WatchKey.pollEvents()) {
                        WatchEvent.Kind<?> EventKind = WatchEvent.kind();
                        if (EventKind == StandardWatchEventKinds.OVERFLOW) {
                            continue; }
                        Path ChangedPath = (Path) WatchEvent.context();
                        if (ChangedPath != null && ChangedPath.equals(ConfigFilePath.getFileName())) {
                            ShouldReload = true; } }
                    if (ShouldReload) {
                       SettingsHandler.load();
                       SettingsInstance = SettingsHandler.instance();
                       ModLogger.info("检测到配置文件变更，已重新加载设置。");}
                    if (!WatchKey.reset()) {
                        break; } }
            } catch (InterruptedException InterruptedException) {
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                throw new RuntimeException(e); } } ) ); }
//    endregion

    @SerialEntry(comment =
        """
        配置文件版本号
        用于在配置文件结构发生变化且需要手动干预时进行兼容性处理
        非必要情况下你不应该手动修改这个数据，否则可能导致本Mod的配置文件出现损坏或其他问题
        类型：整数
        取值范围：0 ~ Long.MAX_VALUE
        当前值：0
        """)
    public long ConfigurationVersionCode = CurrentConfigurationVersionCode;

    @SerialEntry(comment =
        """
        是否启用本模组的功能
        类型：布尔值
        取值范围：true false
        默认值：true
        """)
    public boolean ModEnabled = true;
}
