package Videos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.ArrayList;

/**
 * Created by Ingthor on 6.9.2016.
 */
public class VideoParser {

    /**
     * Prints out information from a file as the programmer wants.
     * Takes in a file as a string. Converts the file to JSONObjects and prints
     * out specific values from the string objects.
     * @param s file which has been converted to String
     */
    public void parseAndPrint(String s)
    {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);

        String status = jsonObject.get("status").toString();
        System.out.println(status);
        String recordCount = jsonObject.get("recordCount").toString();
        System.out.println(recordCount);
        String catalogName =  jsonObject.get("catalog_name").toString();
        System.out.println(catalogName);

        JSONArray catalog = (JSONArray) jsonObject.get("catalog");
        for(int i = 0; i < catalog.size(); i++ )
        {
            JSONObject obj = (JSONObject) catalog.get(i);
            String title = obj.get("title").toString();
            String type = obj.get("type").toString();
            String author_name = obj.get("author_name").toString();

            System.out.print(title + ", " + type + ", " + author_name);
            System.out.println("");
        }
    }

    /**
     * Creates a new Catalog and builds it with objects from the file.
     * Takes in s which is a file converted to string and calls a function in
     * Catalog to build the object model.
     * @param s file which has been converted to String
     * @return cat Catalog instance which has been instantiated
     */
    public Catalog parseVideo(String s)
    {
        Catalog cat = new Catalog();
        cat.buildCatalog(s);
        return cat;
    }

    /**
     * Prints out the object models from Catalog, created for test purposes.
     * Takes in a already built up Catalog and prints out the Name object
     * from Catalog. Title,Type Author from the arraylist in Catalog
     * @param c built up Catalog given from the test function
     */
    public void printCatalog(Catalog c)
    {
        ArrayList<Video> listOfVideos = c.catalogs;
        System.out.println("Catalog: " + c.catalogNames);
        System.out.println("Title                Type                Author");
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i < listOfVideos.size(); i++)
        {
            Video videoObject =  listOfVideos.get(i);
            System.out.println(videoObject.Title + "                " + videoObject.Type + "                 " + videoObject.Author_Name);
        }
    }
}
