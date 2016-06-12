package chain;

/**
 * Created by liju on 5/24/16.
 */
public class Request {
    private RequestType type;
    private boolean requestHandled;
    private String payload;

    public Request(RequestType requestType) {
        this.type = requestType;
    }

    public RequestType getType() {
        return type;
    }

    public boolean isRequestHandled() {
        return requestHandled;
    }

    public void setRequestHandled(boolean requestHandled) {
        this.requestHandled = requestHandled;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Request{" + "type=" + type + ", requestHandled=" + requestHandled + ", payload='" + payload + '\'' + '}';
    }
}
