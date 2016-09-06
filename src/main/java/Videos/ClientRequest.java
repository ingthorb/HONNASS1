package Videos;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ingthor on 6.9.2016.
 *
 */
public class ClientRequest {
    /**
     * Turns the file that is sent in to a string
     * Gets in a file and reads through it with a buffer
     * adding each line to a single String variable
     * @param fileName the file that needs to be turned to string
     * @return finalString which is the file converted into a string
     * @throws RequestException
     */
    public String getFileContent(String fileName) throws RequestException {
        String finalString = "";
        try {
            BufferedReader buffreader = new BufferedReader(new FileReader(fileName));
            StringBuilder returnString = new StringBuilder();
            String nextLine = buffreader.readLine();

            while(nextLine != null)
            {
                returnString.append(nextLine + "\n");
                nextLine = buffreader.readLine();
            }
            buffreader.close();
            finalString = returnString.toString();
        }
        catch (IOException io)
        {
            System.out.println(io.getCause());
        }
        return finalString;
    }

    /**
     * Creates a request,calls it and reads the content from the website
     * Creates a client through ClientBuilder and creates a string through the url which
     * has a file. We convert that to a string and we can print that out.
     * @param url sent in url that is "https://www.mockaroo.com/e97aedd0/download?count=1&key=e79a3650 given
     *            by the teacher
     * @return result which is the complete string from the url
     */
    public String getRequest (String url )
    {
        Client TestParseURL = ClientBuilder.newClient();
        String result = TestParseURL.target(url).request("text/plain").get(String.class);
        return result;
    }
}
