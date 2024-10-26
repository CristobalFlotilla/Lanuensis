package org.flotilla.lanuensis.api.utils;

import club.someoneice.json.JSON;
import club.someoneice.json.node.ArrayNode;
import club.someoneice.json.node.JsonNode;
import club.someoneice.json.node.MapNode;

public class JsonProcessor {

    public static JsonNode<?> getNode(String json) {
        return JSON.json.parse(json);
    }

    public static MapNode getMap(String json) {
        return getNode(json).asMapNodeOrEmpty();
    }

    public static ArrayNode getArray(String json) {
        return getNode(json).asArrayNodeOrEmpty();
    }

}
