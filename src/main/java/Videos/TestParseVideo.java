package Videos;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class TestParseVideo {

    /**
     * Tests the function of parseVideo.
     * Creates new VideoParser,ClientRequest.
     * Turns the file "video.json" into a string
     * Builds up a Catalog and sends it to printCatalog
     * too print out the values
     * @param args
     * @throws RequestException
     */
    public static void main(String[] args) throws RequestException {
        VideoParser vid = new VideoParser();
        ClientRequest cl = new ClientRequest();
        String ss =  cl.getFileContent("videos.json");
        Catalog c = vid.parseVideo(ss);
        vid.printCatalog(c);
    }
}
