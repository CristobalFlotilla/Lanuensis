package org.flotilla.lanuensis.compatibility;

import com.moandjiezana.toml.Toml;
import org.flotilla.lanuensis.api.download.IUpdate;
import org.flotilla.lanuensis.api.mod.Mod;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrismLauncherMetaDataChecker {

    private static final Toml TOML = new Toml();

    public static List<Mod> getModsBy(File minecraftDir) {
        List<Mod> result = new ArrayList<>();

        File modsDir = new File(minecraftDir, "mods");
        File indexDir = new File(modsDir, ".index");

        if (indexDir.isDirectory()) {
            var files = indexDir.listFiles((dir, name) -> name.endsWith("pw.toml"));
            if (files != null) {
                for (File file : files) {
                    var toml = TOML.read(file);
                    var downloadTable = toml.getTable("download");

                    Map<String, String> download = new HashMap<>();
                    download.put("hash", downloadTable.getString("hash"));
                    download.put("format", downloadTable.getString("hash-format"));
                    download.put("mode", downloadTable.getString("mode"));

                    Map<String, IUpdate> update = new HashMap<>();

                    var mod = new Mod(
                            toml.getString("filename"),
                            toml.getString("name"),
                            "PRISM",
                            "PRISM",
                            toml.getString("side"),
                            download,
                            update
                    );
                }
            }
        }

        return result;
    }

}
