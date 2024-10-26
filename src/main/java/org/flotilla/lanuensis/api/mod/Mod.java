package org.flotilla.lanuensis.api.mod;

import org.flotilla.lanuensis.api.download.IDownload;

public class Mod {

    public final String modid, name, version;

    public String fileName;
    public IDownload download;

    public Mod(String modid, String name, String version) {
        this.modid = modid;
        this.name = name;
        this.version = version;
    }
}
