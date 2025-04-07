package br.com.fiap.airquality.repository.user;

import br.com.fiap.airquality.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {

    UserDetails findByEmail(String email);

}
