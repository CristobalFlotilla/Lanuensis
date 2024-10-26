package org.flotilla.lanuensis.common.download;

import org.flotilla.lanuensis.api.download.IDownload;

import java.net.URL;
import java.util.Map;

public class CFDownload implements IDownload {

    private final Map.Entry<String, String> hash;
    private final URL url;

    public CFDownload(String hash, String hashFormat, URL url) {
        this.hash = Map.entry(hashFormat, hash);
        this.url = url;
    }

    @Override
    public Map.Entry<String, String> getHash() {
        return hash;
    }

    @Override
    public String getMode() {
        return "curse";
    }

    @Override
    public String getUrl() {
        return url.toString();
    }

}
