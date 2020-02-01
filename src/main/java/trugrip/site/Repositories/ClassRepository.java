package trugrip.site.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import trugrip.site.Models.SchoolClass;

public interface ClassRepository extends JpaRepository<SchoolClass, Integer> {
}
