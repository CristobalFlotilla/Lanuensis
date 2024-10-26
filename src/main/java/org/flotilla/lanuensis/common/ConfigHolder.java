package org.flotilla.lanuensis.common;

import net.minecraftforge.common.config.Config;
import org.flotilla.lanuensis.Tags;

@Config(modid = Tags.MOD_ID)
public class ConfigHolder {

    @Config.Name("CurseForge Settings")
    public static Curse curse = new Curse();

    public static class Curse {

        @Config.Name("CurseForge Access Key")
        public String apiKey = "$2a$10$ZS5BrrbTqsJdNOKmlZCozuCo49ULIeuq7qvgwQP3fBeJ5SJWHGck2";

    }

}
