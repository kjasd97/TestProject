package ukr.spring.test.Project.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukr.spring.test.Project.models.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


}
