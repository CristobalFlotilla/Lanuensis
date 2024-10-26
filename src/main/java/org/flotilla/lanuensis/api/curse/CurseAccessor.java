package org.flotilla.lanuensis.api.curse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurseAccessor {

    // I think
    private static final String API_KEY = "$2a$10$ZS5BrrbTqsJdNOKmlZCozuCo49ULIeuq7qvgwQP3fBeJ5SJWHGck2";

    private static URL getApi(String path) throws MalformedURLException {
        return new URL("https://api.curseforge.com" + path);
    }

    public static String getResponse() throws IOException {
        URL obj = getApi("/v1/mods/{modId}/files/{fileId}");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
