package xyz.thewhitedog9487;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;

import static xyz.thewhitedog9487.ServerAddressSpaceFixClient.*;

/**
 * 预计27.1正式版发布后删除
 */
@Deprecated
public class RemoveInFuture {
    @Deprecated
    public static void MigrateConfiguration() {
        var OldPath = FabricLoader.getInstance()
                .getConfigDir()
                .resolve(ModID + ".json5")
                .toAbsolutePath();
        if (OldPath.toFile().exists()){
            try {
                ModLogger.info("发现旧的配置文件，正在进行迁移");
                Files.copy(OldPath, Settings.ConfigFilePath);
                boolean IsSuccessDeleted = OldPath.toFile().delete();
                if (IsSuccessDeleted) {
                    ModLogger.info("迁移完成，已删除旧的配置文件");
                } else {
                    ModLogger.warn("迁移完成，但未能删除旧的配置文件，请手动删除 " + OldPath.toAbsolutePath()); }
            } catch (IOException e) {
                ModLogger.error("迁移配置文件失败");
                ModLogger.error(e.getLocalizedMessage());
                e.printStackTrace(); } } } }
