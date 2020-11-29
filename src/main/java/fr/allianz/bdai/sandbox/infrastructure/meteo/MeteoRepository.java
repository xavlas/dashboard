package fr.allianz.bdai.sandbox.infrastructure.meteo;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface MeteoRepository {
    String getCurrentTemperature() throws JsonProcessingException;
    String register(String value);
}
