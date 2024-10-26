package org.flotilla.lanuensis.loader;

import net.minecraftforge.fml.relauncher.IFMLCallHook;

import java.io.File;
import java.util.Map;

public class LanuensisLoader implements IFMLCallHook {

    private File mcLocation;

    @Override
    public void injectData(Map<String, Object> data) {
        mcLocation = (File) data.get("mcLocation");
    }

    @Override
    public Void call() {
        return null;
    }
}
