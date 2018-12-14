package vkComApi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class URI_Builder {

    private String url;
    private Map<String, String> parameters;

    public URI_Builder(String url) {
        this.url = url;
        parameters = new HashMap<String, String>();
    }

    public URI_Builder setParameter(String key, String value) {
        this.parameters.put(key, value);
        return this;
    }

    public URI build() throws URISyntaxException {
        String finallyStringParams = "";
        for (Map.Entry<String, String> entry : parameters.entrySet()){
            if (!entry.getValue().isEmpty()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String urlParam = key + "=" + value + "&";
                finallyStringParams = finallyStringParams.concat(urlParam);
            }
        }
        return new URI(url + normalize(finallyStringParams));
    }

    private String normalize(String encodingStr){
        String normalisedStr = encodingStr
                .substring(0, encodingStr.length() - 1)
                .replace(" ", "%20");
        // normalisedStr = URLEncoder.encode(normalisedStr, "UTF-8");
        return normalisedStr;
    }
}
