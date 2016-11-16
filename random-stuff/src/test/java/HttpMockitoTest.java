import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by Liju on 11/15/2016.
 */
public class HttpMockitoTest {

    @Test
    public void testGetRequest() throws Exception {
        final HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
        final HttpMockito httpMockito = new HttpMockito(mockHttpClient);
        final HttpResponse mockHttpResponse = Mockito.mock(HttpResponse.class);
        final StatusLine mockStatusLine = Mockito.mock(StatusLine.class);
        Mockito.when(mockHttpClient.execute(ArgumentMatchers.any(HttpGet.class))).thenReturn(mockHttpResponse);
        Mockito.when(mockHttpResponse.getStatusLine()).thenReturn(mockStatusLine);
        Mockito.when(mockStatusLine.getStatusCode()).thenReturn(200);
        final HttpResponse response = httpMockito.getRequest("https://url");
        assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
}
