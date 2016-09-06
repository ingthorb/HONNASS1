package Videos;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class RequestException extends Exception {

    public RequestException() {
        super();
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }
}
