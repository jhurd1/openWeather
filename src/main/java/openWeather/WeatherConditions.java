package openWeather;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*****************************************
 * PUBLIC CLASS WEATHERCONDITIONS
 * Integrates with openweather api
 * to serialize Java data members
 ****************************************/
public class WeatherConditions
{
    /*private double temp = 286.99;
    private int pressure = 1013;
    private int humidity = 53;
    private double temp_min = 286.45;
    private double temp_max = 287.55;*/

    /*******************************************
     * PRIVATE MEMBERS
     ******************************************/
    private int id = 0;
    private String name = "";
    private int main = 1;
    private String url = "api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=39d90d5929e83265f2f1669ea3752ed3";
    private String charset = "UTF-8";
    private String param1 = "";
    private String param2 = "";
    private String query = String.format("param1=%s&param2=%s",
            URLEncoder.encode(param1, charset),
            URLEncoder.encode(param1, charset));

    Gson g = new Gson();

    /*******************************************
     * CONSTRUCTOR
     ******************************************/
    WeatherConditions(int id, String name, int main) throws UnsupportedEncodingException
    {
        this.id = id;
        this.name = name;
        this.main = main;
    }

    /*******************************************
     * ACCESSORS
     ******************************************/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMain() {
        return main;
    }

    public Gson getG() {
        return g;
    }

    /*******************************************
    * HTTPGET
    * TEST HTTP GET
    ******************************************/
    public void httpGet() throws IOException
    {
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = connection.getInputStream();
    }
}
