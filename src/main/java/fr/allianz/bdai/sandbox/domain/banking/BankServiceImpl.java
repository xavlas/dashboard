package fr.allianz.bdai.sandbox.domain.banking;

public class BankServiceImpl implements BankService{

    private final BankDao bankDao;

    public BankServiceImpl(BankDao dao) {
        this.bankDao = dao;
    }

    @Override
    public String findBy() {
        return this.bankDao.findby();
    }

}
