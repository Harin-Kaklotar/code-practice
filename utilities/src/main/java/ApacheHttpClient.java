import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * HTTP GET and POST using HTTPURLConnection
 */
public class ApacheHttpClient {

    private final CloseableHttpClient closeableHttpClient;

    public ApacheHttpClient(boolean basicAuthRequired) {
        if (basicAuthRequired) {
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("userid", "password"));

            this.closeableHttpClient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        } else {
            this.closeableHttpClient = HttpClients.createDefault();
        }

    }

    /**
     * HTTP GET
     */
    public void get(){
        CloseableHttpResponse response = null;
        String responseStr;
        try {
            String url  = "http://requestb.in/oiimudoi";
            response = closeableHttpClient.execute(new HttpGet(url));

            if (response.getEntity() != null) {
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    responseStr = EntityUtils.toString(response.getEntity());

                    System.out.println(responseStr);
                } else {
                    System.out.println("Response not ok");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ApacheHttpClient client = new ApacheHttpClient(false);
        client.get();
    }
}
