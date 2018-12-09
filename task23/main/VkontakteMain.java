package task23;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class VkontakteMain {
    private static final String CLIENT_ID = "6762704";
    private static final String SCOPE = "offline";
    private static final String VERSION = "5.92";

    public String getToken() {
        String token = "3ef1de03f236b4a46e95599ce8fdae460b43d569eaa998a7cc1cb1062acbc4347fa4b8a4400a5e5da6c17";
        return token;
    }

    public String getToken(String scope) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = null;
        String token = null;
        builder = new URIBuilder("https://oauth.vk.com/authorize?");
        builder.setParameter("client_id", CLIENT_ID)
                .setParameter("display", "page")
                .setParameter("redirect_uri", "https://oauth.vk.com/blank.html")
                .setParameter("response_type", "token")
                .setParameter("callback", "")
                .setParameter("state", "123456")
                .setParameter("scope", scope)
                .setParameter("v", VERSION);
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String url = request.getURI().toString();
        System.out.println(url);
        token = EntityUtils.toString(response.getEntity());
        return token;
    }

    public String sendMessage(String userId, String message) {
        HttpClient client = HttpClientBuilder.create().build();
        String messageID = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/messages.send?");
            builder.setParameter("access_token", getToken())
                    .setParameter("user_id", userId)
                    .setParameter("random_id", userId + generateRandomNumber())
                    .setParameter("message", message)
                    .setParameter("v", VERSION);
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            messageID = getID(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return messageID;
    }

    public String editMessage(String peer_id, String message_id, String message) {
        HttpClient client = HttpClientBuilder.create().build();
        String messageID = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/messages.edit?");
            builder.setParameter("access_token", getToken())
                    .setParameter("peer_id", peer_id)
                    .setParameter("message_id", message_id)
                    .setParameter("message", message)
                    .setParameter("v", VERSION);
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            messageID = getID(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return messageID;
    }

    public int deleteMessage(String message_id) {
        HttpClient client = HttpClientBuilder.create().build();
        int resultCode = 0;
        try {
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/messages.delete?");
            builder.setParameter("access_token", getToken())
                    .setParameter("delete_for_all", "0")
                    .setParameter("message_id", message_id)
                    .setParameter("v", VERSION);
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            resultCode = response.getStatusLine().getStatusCode();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultCode;
    }

    public String sendPhoto(String userId, String message, String media_id) {
        HttpClient client = HttpClientBuilder.create().build();
        String messageID = null;
        String typeMedia = "photo";
        try {
            URIBuilder builder = new URIBuilder("https://api.vk.com/method/messages.send?");
            builder.setParameter("access_token", getToken())
                    .setParameter("user_id", userId)
                    .setParameter("random_id", userId + generateRandomNumber())
                    .setParameter("message", message)
                    .setParameter("attachment", typeMedia + userId + "_" + media_id)
                    .setParameter("v", VERSION);
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            messageID = getID(EntityUtils.toString(response.getEntity()));
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return messageID;
    }

    public boolean isMessageExist(String message_id) {
        int successfulStatusCode = 200;
        HttpClient client = HttpClientBuilder.create().build();
        int result = 0;
        try {
            URIBuilder builder = new URIBuilder("https://api.vk.com/method//messages.getById?");
            builder.setParameter("access_token", getToken())
                    .setParameter("message_ids", message_id)
                    .setParameter("v", VERSION);
            HttpGet request = new HttpGet(builder.build());
            HttpResponse response = client.execute(request);
            result = response.getStatusLine().getStatusCode();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result == successfulStatusCode;

    }

    private int generateRandomNumber() {
        int rangeStart = 100000;
        int finishStart = 9999999;
        int randomNumber = rangeStart + (int) (Math.random() * (finishStart - rangeStart));
        System.out.print(randomNumber);
        return randomNumber;
    }

    private String getID(String s) {
        return s.replaceAll("[^0-9]", "");
    }
}