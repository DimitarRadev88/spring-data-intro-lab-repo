package bg.softuni.springDataIntro.service;

import bg.softuni.springDataIntro.entity.User;
import bg.softuni.springDataIntro.repository.UserRepository;
import bg.softuni.springDataIntro.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        if (userRepository.getByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("User already exists");
        }

        userRepository.save(user);
    }

}
