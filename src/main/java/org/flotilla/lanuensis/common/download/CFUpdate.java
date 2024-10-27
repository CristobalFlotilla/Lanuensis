package org.flotilla.lanuensis.common.download;

import lombok.AllArgsConstructor;
import org.flotilla.lanuensis.api.download.IUpdate;

@AllArgsConstructor
public class CFUpdate implements IUpdate {

    public int project, file;

    @Override
    public String getName() {
        return "curseforge";
    }
}
