package org.flotilla.lanuensis.api.utils;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.flotilla.lanuensis.common.ConfigHolder;

import java.io.IOException;
import java.net.MalformedURLException;

public class CurseAccessor {

    private static final String API_KEY = ConfigHolder.curse.apiKey;
    private static final int MINECRAFT = 432;
    private static final int MC_MODS = 6;

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    private static HttpGet getApi(String path, Object... format) throws MalformedURLException {
        return new HttpGet(String.format("https://api.curseforge.com" + path, format));
    }

    public static String getResponse(String path, Object... format) throws IOException {
        HttpGet get = getApi(path, format);
        get.addHeader("Accept", "application/json");
        get.addHeader("x-api-key", API_KEY);
        return EntityUtils.toString(httpClient.execute(get).getEntity());
    }

    public static String search(String searchFilter) throws IOException {
        return getResponse(CUrl.of("/v1/mods/search")
                .addArg("gameId", MINECRAFT)
                .addArg("categoryId", MC_MODS)
                .addArg("searchFilter", searchFilter)
                .toString());
    }

    public static String searchBySlug(String slug) throws IOException {
        return getResponse(CUrl.of("/v1/mods/search")
                .addArg("gameId", MINECRAFT)
                .addArg("categoryId", MC_MODS)
                .addArg("slug", slug)
                .toString());
    }

    public static String searchById(long id) throws IOException {
        return getResponse(CUrl.of(String.format("/v1/mods/%s", id)).toString());
    }

}
