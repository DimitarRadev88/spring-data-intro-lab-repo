package bg.softuni.springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Long id);

    void transferMoney(BigDecimal amount, Long id);

}
