package Videos;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class TestParseURL {
    /**
     * Tests the function of ParseUrl.
     * Creates new VideoParser,ClientRequest.
     * Turns the given url nto a string
     * Sends the string to parseAndPrint to print the values
     * @param args
     * @throws RequestException
     */
    public static void main(String[] args) throws RequestException {
        ClientRequest cl = new ClientRequest();
        VideoParser vid = new VideoParser();
        String ssl = cl.getRequest("https://www.mockaroo.com/e97aedd0/download?count=1&key=e79a3650");
        vid.parseAndPrint(ssl);
    }
}
