package openWeather;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/*****************************************
 * PUBLIC CLASS WEATHERCONDITIONS
 * Integrates with openweather api
 * to serialize Java data members
 ****************************************/
public class WeatherConditions
{

    /*******************************************
     * PRIVATE MEMBERS
     ******************************************/
    private int id;
    private String name;
    Map<String, Float> main;
    //@SerializedName("main")
    /*private String url = "api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=39d90d5929e83265f2f1669ea3752ed3";
    private String charset = "UTF-8";
    private String param1 = "";
    private String param2 = "";
    private String query = String.format("param1=%s&param2=%s",
            URLEncoder.encode(param1, charset),
            URLEncoder.encode(param1, charset));*/

    public String weatherUnderground()
    {
            Gson g = new Gson();
            String gsonOutput = g.toJson(main); //serialized the string
        return gsonOutput;
    }


    /*******************************************
     * CONSTRUCTOR
     ******************************************/

    WeatherConditions()
    {

    }
    WeatherConditions(int id, String name, Map<String, Float> main) throws UnsupportedEncodingException
    {
        this.id = id;
        this.name = name;
        this.main = main;
    }

    /*******************************************
     * ACCESSORS
     ******************************************/
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Map<String, Float> getMain() {
        return main;
    }

    /*******************************************
    * HTTPGET
    * TEST HTTP GET
    ******************************************/
    /*public void httpGet() throws IOException
    {
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
    }*/
}
