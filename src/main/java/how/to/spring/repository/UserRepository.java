package how.to.spring.repository;

import how.to.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByFirstNameAndLastName(String firstName, String lastName);

}
