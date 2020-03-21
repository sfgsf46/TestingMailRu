package apiTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

public class Vk {
    private HttpClient client;
    private URIBuilder builder;
    private HttpGet request;
    private HttpResponse response;
    private String postId;

    public Vk() {
        client = HttpClientBuilder.create().build();
    }

    public void writeAMessageOnTheWall(String message) throws URISyntaxException, IOException {
        builder = new URIBuilder("https://api.vk.com/method/wall.post?");
        builder.setParameter("access_token", "73a859715d1e373c084f4415af93661fd7230dd87ae4ddd488a999924199adef3766748805d9f57386fce")
                .setParameter("owner_id", "136538024")
                .setParameter("message", message)
                .setParameter("v", "5.103");
        request = new HttpGet(builder.build());
        response = client.execute(request);
        postId = EntityUtils.toString(response.getEntity()).replaceAll("\\D", "");
        Assert.assertTrue(this.postId.matches("\\d+"));
        System.out.println(message);
    }

    public void editMessage(String messageNew) throws URISyntaxException, IOException {
        builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builder.setParameter("access_token", "73a859715d1e373c084f4415af93661fd7230dd87ae4ddd488a999924199adef3766748805d9f57386fce")
                .setParameter("owner_id", "136538024")
                .setParameter("post_id", postId)
                .setParameter("message", messageNew)
                .setParameter("v", "5.103");
        request = new HttpGet(builder.build());
        response = client.execute(request);
        System.out.println(messageNew);
    }

    public void deleteMessage() throws URISyntaxException, IOException {
        builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
        builder.setParameter("access_token", "73a859715d1e373c084f4415af93661fd7230dd87ae4ddd488a999924199adef3766748805d9f57386fce")
                .setParameter("owner_id", "136538024")
                .setParameter("post_id", postId)
                .setParameter("v", "5.103");
        request = new HttpGet(builder.build());
        response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }
}
