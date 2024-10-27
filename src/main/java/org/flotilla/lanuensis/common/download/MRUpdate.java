package org.flotilla.lanuensis.common.download;

import lombok.AllArgsConstructor;
import org.flotilla.lanuensis.api.download.IUpdate;

@AllArgsConstructor
public class MRUpdate implements IUpdate {

    public String project, version;

    @Override
    public String getName() {
        return "modrinth";
    }
}
