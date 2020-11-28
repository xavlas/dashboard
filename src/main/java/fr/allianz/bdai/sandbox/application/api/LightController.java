package fr.allianz.bdai.sandbox.application.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api", produces = APPLICATION_JSON_VALUE)
public class LightController {
    private static final ObjectMapper MAPPER = new ObjectMapper().registerModules(new Jdk8Module(), new JavaTimeModule());

    @GetMapping("/light")
    public ResponseEntity<String> light(HttpServletRequest request) throws URISyntaxException {
        try {
            return ResponseEntity.ok(MAPPER.writeValueAsString("24"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "données du jeton introuvable");
        }
    }
}
