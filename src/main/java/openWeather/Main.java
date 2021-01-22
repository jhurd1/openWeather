package openWeather;

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
}
