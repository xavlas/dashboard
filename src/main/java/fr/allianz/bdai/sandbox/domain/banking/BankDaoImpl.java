package fr.allianz.bdai.sandbox.domain.banking;

import org.springframework.stereotype.Service;

@Service
public class BankDaoImpl implements BankDao {

    @Override
    public String findby() {
        return "Xavier";
    }
}
