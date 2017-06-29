package json;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WeatherEvent{
    private static OkHttpClient client = new OkHttpClient();
    private String state;
    private String city;
    private CurrentObservation obs;

    public WeatherEvent(String city, String state){
        this.city = city;
        this.state = state;

        //Initialize the CurrentObservation
        String json = null;
        try {
            json = getJSON("http://api.wunderground.com/api/1e087afac4307d67/conditions/q/"
                    + state + "/" + city + ".json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Weather weather = gson.fromJson(json, Weather.class);
        obs = weather.getCurrentObservation();
    }

    private String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        okhttp3.Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String getCondition() {
        return obs.getWeather();
    }

    public String getTemp() {
        return obs.getTemperatureString();
    }
}
