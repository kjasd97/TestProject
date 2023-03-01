package ukr.spring.test.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ukr.spring.test.Project.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
