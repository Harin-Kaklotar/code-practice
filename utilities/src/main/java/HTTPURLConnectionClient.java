import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * Created by liju on 11/10/16.
 * HTTP GET and POST using HttpURLConnection api
 */
public class HTTPURLConnectionClient {

    private boolean basicAuthRequired;

    public HTTPURLConnectionClient(boolean basicAuthRequired) {
        this.basicAuthRequired = basicAuthRequired;
    }

    /**
     * HTTP GET example
     */
    public void get() {
        InputStream inputStream = null;
        try {
            String url = "http://httpbin.org/get";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            if (basicAuthRequired) {
                String encoded = Base64.getEncoder().encodeToString("username:password".getBytes());
                con.setRequestProperty("Authorization", "Basic " + encoded);
            }
            con.setRequestMethod("GET");
            final int responseCode = con.getResponseCode();
            System.out.println("Get response code - " + responseCode);

            inputStream = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            System.out.println("GET response  - " + sb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * HTTP Post example
     */
    public void post(String jsonString) {

        DataOutputStream dataOutputStream = null;
        InputStream inputStream = null;
        try {
            String url = "http://httpbin.org/post";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            if (basicAuthRequired) {
                String encoded = Base64.getEncoder().encodeToString("username:password".getBytes());
                con.setRequestProperty("Authorization", "Basic " + encoded);
            }
            con.setRequestMethod("POST");
            con.setRequestProperty("content-type", "application/json");

            // send post request
            con.setDoOutput(true);

            dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.write(jsonString.getBytes());
            dataOutputStream.flush();

            final int responseCode = con.getResponseCode();
            System.out.println("POST response code - " + responseCode);

            inputStream = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            System.out.println("POST response  - " + sb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        HTTPURLConnectionClient client = new HTTPURLConnectionClient(false);
        client.get();
        client.post("{\"key\":\"value\"}");
    }
}
