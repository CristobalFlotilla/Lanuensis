package org.flotilla.lanuensis.api.mod;

public class Mod {

    public final String modid, name, version;

    public String fileName;
    public String downloadUrl;

    public Mod(String modid, String name, String version) {
        this.modid = modid;
        this.name = name;
        this.version = version;
    }
}
