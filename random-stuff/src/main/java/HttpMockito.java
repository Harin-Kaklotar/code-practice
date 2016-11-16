import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by Liju on 11/15/2016.
 */
public class HttpMockito {
    private HttpClient httpClient ;
    HttpMockito(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public HttpResponse getRequest(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        HttpResponse response = httpClient.execute(get);
        return response;
    }
}
