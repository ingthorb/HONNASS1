package Videos;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class TestParseFile {
    /**
     * Tests the function of ParseFile.
     * Creates new VideoParser,ClientRequest.
     * Turns the given file into a string
     * Sends the string to parseAndPrint to print the values
     * @param args
     * @throws RequestException
     */
    public static void main(String[] args) throws RequestException {
        ClientRequest cl = new ClientRequest();
        String ss =  cl.getFileContent("videos.json");
        VideoParser vid = new VideoParser();
        vid.parseAndPrint(ss);
    }
}
