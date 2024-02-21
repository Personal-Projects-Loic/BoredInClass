import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.util.Scanner;

public class WeatherApp {
    public static int[] lon = { -90, 90 }; 
    public static int[] lat = { -180, 180 };
    private static final String API_KEY = "88d490434002726d5241f8845d848de3";
    private static final String API_URL = "https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}";

    public static void main(String[] args) {
        String city = "London";
        try {
            String weatherData = getWeatherData(city);
            System.out.println("Weather in " + city + ":");
            System.out.println(weatherData);
        } catch (IOException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private static String getWeatherData(String city) throws IOException {
        String apiUrl = String.format(API_URL, city, API_KEY);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}
