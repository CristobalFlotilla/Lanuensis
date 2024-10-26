package org.flotilla.lanuensis.api.download;

import java.util.Map;

public interface IDownload {

    Map.Entry<String, String> getHash();

    String getMode();

    String getUrl();

}
