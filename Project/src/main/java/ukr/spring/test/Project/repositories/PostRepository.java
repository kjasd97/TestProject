package ukr.spring.test.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ukr.spring.test.Project.models.Person;
import ukr.spring.test.Project.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

    public Post findPostByTitle(String title);


}
