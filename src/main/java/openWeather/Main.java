package openWeather;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    /*private static String city;
    private static final String url = "https://api.openweathermap.org/data/2.5/weather";
    private static final String key = "39d90d5929e83265f2f1669ea3752ed3";
    private static final String charset = "UTF-8";
    private static int id = this.id;
    private static String name = this.name;
    static Map<String, Float> main = new HashMap<String, Float>;
*/

    public static void main (String[] args) throws IOException {
        System.out.print("Enter city name: ");
        Scanner scanner = new Scanner(System.in);
        WeatherConditions w = new WeatherConditions();
        String name = w.getName();
        name = scanner.next();
        Gson gson = new Gson();
        w = gson.fromJson(w.weatherUnderground(), WeatherConditions.class); //deserialized string to object


       /* try w.getId() + w.getName();
        {
            // ?q=London,uk&APPID=
            String query = String.format("?q=%s&apiKey=%s",
                    URLEncoder.encode(city, charset),
                    URLEncoder.encode(key, charset));
            URLConnection connection = null;
            connection = new URL(url+query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            Gson gson = new Gson();
            WeatherConditions conditions = gson.fromJson(stringBuilder.toString(), WeatherConditions.class);
            System.out.println(stringBuilder.toString());
        }
        catch (UnsupportedEncodingException ex)
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
