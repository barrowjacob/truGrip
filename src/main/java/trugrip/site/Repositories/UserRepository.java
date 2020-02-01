package trugrip.site.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trugrip.site.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
