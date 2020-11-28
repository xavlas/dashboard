package fr.allianz.bdai.sandbox.domain.meteo;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.allianz.bdai.sandbox.infrastructure.meteo.MeteoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MeteoServiceImpl implements MeteoService {

    private MeteoRepository meteoRepository;

    public MeteoServiceImpl(MeteoRepository meteoRepository) {
        this.meteoRepository = meteoRepository;
    }

    @Override
    public String getCurrentTemperature() {
        try {
            String currentTemperature = this.meteoRepository.getCurrentTemperature();
            log.info("Current Temperature {}", currentTemperature);
            return currentTemperature;
        } catch (JsonProcessingException e) {
            log.info("erreur when processing meteo service {}", e);
        }
        return "default";
    }
}
