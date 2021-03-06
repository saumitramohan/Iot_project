package sample.data.jpa.service;
import sample.data.jpa.domain.User;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {
        User findAllByUsername(String username);
        User findAllByDeviceId(String deviceId);

}
