package openWeather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main
{
    private static String city;
    private static final String url = "https://api.openweathermap.org/data/2.5/weather";
    private static final String key = "39d90d5929e83265f2f1669ea3752ed3";
    private static final String charset = "UTF-8";

    public static void main (String[] args) throws UnsupportedEncodingException {
        System.out.print("Enter city: ");
        Scanner scanner = new Scanner(System.in);
        city = scanner.next();

        try
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
        }
    }
}
