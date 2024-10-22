package br.com.fiap.airquality.service.user;

import br.com.fiap.airquality.model.user.User;
import br.com.fiap.airquality.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.delete(
                userRepository.findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    public User update(User user) {

        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isPresent()) {
            return userRepository.save(user);
        }

        else {
            throw new RuntimeException();
        }

    }

}
