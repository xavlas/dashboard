package fr.allianz.bdai.sandbox.application.config;

import fr.allianz.bdai.sandbox.domain.banking.BankDao;
import fr.allianz.bdai.sandbox.domain.banking.BankService;
import fr.allianz.bdai.sandbox.domain.banking.BankServiceImpl;
import fr.allianz.bdai.sandbox.domain.meteo.MeteoService;
import fr.allianz.bdai.sandbox.domain.meteo.MeteoServiceImpl;
import fr.allianz.bdai.sandbox.infrastructure.meteo.MeteoRepository;
import fr.allianz.bdai.sandbox.infrastructure.meteo.MeteoRepositoryDao;
import fr.allianz.bdai.sandbox.infrastructure.meteo.MeteoRepositoryImpl;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BankService bankService(BankDao bankDao) {
        return new BankServiceImpl(bankDao);
    }

    @Bean
    public MeteoService meteoService(MeteoRepository repo) {
        return new MeteoServiceImpl(repo);
    }

}
