package org.flotilla.lanuensis.api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String toString(Object type) {
        return GSON.toJson(type);
    }

    public static <T> T toObject(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

}
