package openWeather;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
    @SerializedName("main") //tells the IDE to associate members of measurements with "main"
    Map<String, Float> measurements;
    private float temp;
    private float pressure;
    private float humidity;
    private float temp_min;
    private float temp_max;
    private String charset = "UTF-8";
    /******************************************
     * GETTHEWEATHER
     * @return
     *****************************************/
    public void getTheWeatherFromAPI() throws IOException, UnirestException {
        HttpResponse<String> httpResponse = Unirest.get("api.openweathermap.org/data/2.5/weather?q="
        + name + "&APPID=39d90d5929e83265f2f1669ea3752ed3")
                .header("temp", String.valueOf(temp))
                .header("pressure", String.valueOf(pressure))
                .header("humidity", String.valueOf(humidity))
                .header("temp_min", String.valueOf(temp_min))
                .header("temp_max", String.valueOf(temp_max))
       .asString();
        System.out.println(httpResponse.getHeaders().get("Content-Type"));
    }
    /******************************************
     * PUTSTUFFINTHEMAP
     * @return
     *****************************************/

    /******************************************
     * WEATHERUNDERGROUND
     * @return gsonoutput
     *****************************************/
    public String weatherUnderground()
    {
            Gson g = new Gson();
            String gsonOutput = g.toJson(measurements); //serialized the string
            System.out.print(measurements); // verify a positive return of data
        return gsonOutput;
    }
    /*******************************************
     * CONSTRUCTORS
     ******************************************/
    WeatherConditions()
    {

    }

    WeatherConditions(int id, String name, Map<String, Float> main) throws UnsupportedEncodingException
    {
        this.id = id;
        this.name = name;
        //this.measurements = main;
        this.measurements = measurements;
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
        return measurements;
    }
}/****END***/
