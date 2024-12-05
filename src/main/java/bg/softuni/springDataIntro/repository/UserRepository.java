package bg.softuni.springDataIntro.repository;

import bg.softuni.springDataIntro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

}
