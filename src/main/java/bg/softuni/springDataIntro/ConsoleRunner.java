package bg.softuni.springDataIntro;

import bg.softuni.springDataIntro.entity.Account;
import bg.softuni.springDataIntro.entity.User;
import bg.softuni.springDataIntro.service.interfaces.AccountService;
import bg.softuni.springDataIntro.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Gosho", 30);

        Account account = new Account(new BigDecimal("25000"));
        account.setUser(user);

        user.setAccounts(new HashSet<>());
        user.getAccounts().add(account);

        userService.registerUser(user);

        accountService.withdrawMoney(new BigDecimal("20000"), account.getId());
        accountService.withdrawMoney(new BigDecimal("25000"), account.getId());

    }
}
