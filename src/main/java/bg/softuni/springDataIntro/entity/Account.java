package bg.softuni.springDataIntro.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    private BigDecimal balance;
    private User user;

    public Account() {}

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
