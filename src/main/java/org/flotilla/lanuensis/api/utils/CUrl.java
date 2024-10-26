package org.flotilla.lanuensis.api.utils;

public class CUrl {

    private final StringBuilder mainUrl;

    private CUrl(String mainUrl) {
        this.mainUrl = new StringBuilder(mainUrl);
    }

    public static CUrl of(String mainUrl) {
        return new CUrl(mainUrl + "?");
    }

    public CUrl addArg(String type, Object value) {
        mainUrl.append(String.format("%s=%s&", type, value));
        return this;
    }

    @Override
    public String toString() {
        return mainUrl.toString();
    }

}
