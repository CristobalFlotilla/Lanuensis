package org.flotilla.lanuensis.api.mod;

import club.someoneice.json.node.JsonNode;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import org.flotilla.lanuensis.Lanuensis;
import org.flotilla.lanuensis.api.utils.CurseAccessor;
import org.flotilla.lanuensis.api.utils.JsonProcessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ModChecker {

    public static List<Mod> getModlist(File minecraftDir) {
        List<Mod> result = new ArrayList<>();

        File modsDir = new File(minecraftDir, "mods");
        File indexDir = new File(modsDir, ".index");
        if (indexDir.isDirectory()) {
        }

        for (ModContainer modContainer : Loader.instance().getModList()) {
            var id = modContainer.getModId();
            var name = modContainer.getName();
            var version = modContainer.getVersion();

            try {
                var response1 = CurseAccessor.search(name);
                var response2 = CurseAccessor.searchBySlug(id.toLowerCase(Locale.ROOT).replace('_', '-'));

                var data1 = JsonProcessor.getMap(response1).get("data").asArrayNodeOrEmpty().get(0).asMapNodeOrEmpty();
                var data2 = JsonProcessor.getMap(response2).get("data").asArrayNodeOrEmpty().get(0).asMapNodeOrEmpty();

                if (data1.get("id").asTypeNodeOrThrow(JsonNode.NodeType.Int).getObj() == data2.get("id").asTypeNodeOrThrow(JsonNode.NodeType.Int).getObj()) {

                }
            } catch (IOException e) {
                Lanuensis.LOGGER.error("Error Message: Cannot get response");
                throw new RuntimeException(e);
            }
        }

        return result;
    }

}
