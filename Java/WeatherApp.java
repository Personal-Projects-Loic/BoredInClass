import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {
    private static Scanner scanner = new Scanner(System.in);
    private static final String API_KEY = "898f57194620afa1b7063fe0cff00c6b";
    private static final String API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=Brockport&limit=5&appid=898f57194620afa1b7063fe0cff00c6b";

    public static void main(String[] args) {
        String city = "Brockport";
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
