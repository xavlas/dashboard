package fr.allianz.bdai.sandbox.infrastructure.meteo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@Configuration
public class MeteoRepositoryImpl implements MeteoRepository {

    @Value("${meteo.url}")
    private String meteoUrl;

    @Override
    public String getCurrentTemperature() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        ResponseEntity<Weather> response = restTemplate
                .getForEntity(meteoUrl, Weather.class);
        log.info("meteo :" + response);
        var temperature = response.getBody().getMain().getTemp();
        log.info("temperature {}:" + temperature);
        return String.valueOf(temperature+"°");
    }

    @Override
    public String register(String value) {
        return null;
    }
}
