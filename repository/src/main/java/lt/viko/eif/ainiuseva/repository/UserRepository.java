package lt.viko.eif.ainiuseva.repository;

import lt.viko.eif.ainiuseva.model.TripSeats;
import lt.viko.eif.ainiuseva.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByUsernameOrEmail(String username, String email);

    Optional<User> getUserByUsernameAndPassword(String username, String password);
}
