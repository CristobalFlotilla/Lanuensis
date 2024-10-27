package org.flotilla.lanuensis.api.parser;

import org.flotilla.lanuensis.api.mod.Mod;
import org.flotilla.lanuensis.api.utils.GsonUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ModParser {

    public ModParser() {}

    public static String serializeMod(Mod mod) {
        return GsonUtils.toString(mod);
    }

    public static Mod deserializeMod(String mod) {
        return GsonUtils.toObject(mod, Mod.class);
    }

    public static File serializeModToFile(String path, Mod mod) {
        var file = new File(path);
        try {
            var outputStream = Files.newOutputStream(file.toPath());
            outputStream.write(serializeMod(mod).getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public static Mod deserializeFileToMod(String path) {
        var file = new File(path);
        var output = "";
        try {
            var inputStream = Files.newInputStream(file.toPath());
            output = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deserializeMod(output);
    }
}
