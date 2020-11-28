package fr.allianz.bdai.sandbox.infrastructure.meteo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class MeteoRepositoryImpl implements MeteoRepository {

    @Override
    public String getCurrentTemperature() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        String fooResourceUrl
                = "https://api.openweathermap.org/data/2.5/weather?q=Paris&appid=0b545af03efb9154273367ce5a8cf834&units=metric";
        ResponseEntity<Weather> response = restTemplate
                .getForEntity(fooResourceUrl, Weather.class);
        log.info("meteo :" + response);
        var temperature = response.getBody().getMain().getTemp();
        log.info("temperature {}:" + temperature);
        return String.valueOf(temperature+"°");
    }
}
