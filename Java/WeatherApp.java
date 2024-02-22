import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {
    private static Scanner scanner = new Scanner(System.in);
    private static final String API_KEY = "898f57194620afa1b7063fe0cff00c6b";
    private static final String API_URL = "http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=5&appid=%s";

    public static void main(String[] args) {
        System.out.println("Weather Application");
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        try {
            String weatherData = getWeatherData(city);
            System.out.println("Weather in " + city + ":");
            System.out.println(weatherData);
        } catch (IOException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }

    public static void writeData(String data) throws IOException {
        BufferedWriter out = null;
    
        try {
            FileWriter fstream = new FileWriter("out.txt", true);
            out = new BufferedWriter(fstream);
            out.write("\n" + data);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static String getWeatherData(String city) throws IOException {
        String apiUrl = String.format(API_URL, city, API_KEY);
        System.out.println(apiUrl);
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
    
        try {
            writeData(response.toString());
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }
    
        return response.toString();
    }
}
