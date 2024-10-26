package org.flotilla.lanuensis.loader;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LanuensisFMLPlugin implements IFMLLoadingPlugin {

    @Override public String[] getASMTransformerClass() {return new String[0];}

    @Override public String getModContainerClass() {return null;}

    @Override public void injectData(Map<String, Object> data) {}

    @Override public String getAccessTransformerClass() {return null;}

    @Nullable
    @Override
    public String getSetupClass() {
        return "org.flotilla.lanuensis.loader.LanuensisLoader";
    }
}
