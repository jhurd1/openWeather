package openWeather;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class Main
{
    //int id, String name, int main
    int id;
    String name;
    int main;
    WeatherConditions wc = new WeatherConditions(id, name, main);

    public Main() throws UnsupportedEncodingException {
    }

    public static void main (String[] args)
    {
        Gson gson = new Gson();
    }
}
