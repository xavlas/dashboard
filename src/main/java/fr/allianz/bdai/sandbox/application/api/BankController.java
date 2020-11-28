package fr.allianz.bdai.sandbox.application.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.allianz.bdai.sandbox.domain.banking.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api", produces = APPLICATION_JSON_VALUE)
public class BankController {
    private static final ObjectMapper MAPPER = new ObjectMapper().registerModules(new Jdk8Module(), new JavaTimeModule());

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    @GetMapping("/bank")
    public ResponseEntity<String> bank(HttpServletRequest request) throws URISyntaxException {
        try {
            var value = this.bankService.findBy();
            return ResponseEntity.ok(MAPPER.writeValueAsString(value));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "données du jeton introuvable");
        }
    }
}
