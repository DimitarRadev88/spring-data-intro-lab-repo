package bg.softuni.springDataIntro.service;

import bg.softuni.springDataIntro.entity.Account;
import bg.softuni.springDataIntro.entity.User;
import bg.softuni.springDataIntro.repository.AccountRepository;
import bg.softuni.springDataIntro.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Account account = accountRepository.findAccountById(id);

        validateAccount(account);

        User user = account.getUser();

        validateUser(user);

        validateBalance(amount, account);

        account.setBalance(account.getBalance().subtract(amount));

        accountRepository.save(account);

    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        Account account = accountRepository.findAccountById(id);

        User user = account.getUser();

        validateUser(user);

        if (amount.compareTo(new BigDecimal("0")) < 0) {
            throw new IllegalArgumentException("Cannot transfer negative amount");
        }

        account.setBalance(account.getBalance().add(amount));

        accountRepository.save(account);
    }

    private static void validateBalance(BigDecimal amount, Account account) {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
    }

    private static void validateUser(User user) {
        if (user == null) {
            throw new IllegalStateException("No user found for account");
        }
    }

    private static void validateAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist");
        }
    }


}
