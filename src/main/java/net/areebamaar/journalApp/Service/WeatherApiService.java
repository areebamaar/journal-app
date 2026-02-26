package net.areebamaar.journalApp.Service;

import net.areebamaar.journalApp.Cache.AppCache;
import net.areebamaar.journalApp.Constants.PlaceHolders;
import net.areebamaar.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {

    @Value("${weather.api.key}")
    private  String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse= redisService.get("weather of "+city, WeatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        }else {
            String finalApi = appCache.appCache.get(AppCache.keys.weather_api.toString())
                    .replace(PlaceHolders.CITY, city)
                    .replace(PlaceHolders.API_KEY, apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null){
                redisService.set("weather of "+city, body, 300l);
            }
            return body;
        }
    }


}
