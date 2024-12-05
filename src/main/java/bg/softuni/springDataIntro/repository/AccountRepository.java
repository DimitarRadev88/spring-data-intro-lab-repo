package bg.softuni.springDataIntro.repository;

import bg.softuni.springDataIntro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.id = ?1")
    Account findAccountById(Long id);

}
