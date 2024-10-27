package org.flotilla.lanuensis.api.mod;

import lombok.AllArgsConstructor;
import org.flotilla.lanuensis.api.download.IUpdate;

import java.util.Map;

@AllArgsConstructor
public class Mod {
    public String filename, name, modid, version, side;
    public Map<String, String> download;
    public Map<String, IUpdate> update;
}
