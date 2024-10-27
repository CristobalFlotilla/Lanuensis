package org.flotilla.lanuensis.common.download;

import lombok.AllArgsConstructor;
import org.flotilla.lanuensis.api.download.IUpdate;

@AllArgsConstructor
public class URLUpdate implements IUpdate {

    public String url;

    @Override
    public String getName() {
        return "url";
    }
}
