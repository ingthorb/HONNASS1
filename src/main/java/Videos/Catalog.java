package Videos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.ArrayList;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class Catalog {

        public String catalogNames;
        public ArrayList<Video> catalogs = new ArrayList<Video>();

    /**
     * Builds up Catalog instance with taking in a string s which was a file.
     * Creates a Jsonobject from the file so that the objects can be extracted
     * Setting the instance of catalogNames to the name of the file which was sent in
     * Getting the title, type and name of the author and adding it to the arrayList of catalogs
     * @param s String of the converted file
     */
    public void buildCatalog(String s)
    {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        catalogNames =  jsonObject.get("catalog_name").toString();
        JSONArray catalog = (JSONArray) jsonObject.get("catalog");

        for(int i = 0; i < catalog.size(); i++ )
        {
            JSONObject obj = (JSONObject) catalog.get(i);
            String title = obj.get("title").toString();
            String type = obj.get("type").toString();
            String author_name = obj.get("author_name").toString();
            Video vid = new Video(title, type, author_name);
            catalogs.add(vid);
        }
    }
}
