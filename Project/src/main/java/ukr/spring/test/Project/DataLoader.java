package ukr.spring.test.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ukr.spring.test.Project.dto.PersonDTO;
import ukr.spring.test.Project.dto.PostDTO;
import ukr.spring.test.Project.models.Comment;
import ukr.spring.test.Project.models.Person;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.repositories.CommentRepository;
import ukr.spring.test.Project.repositories.PersonRepository;
import ukr.spring.test.Project.repositories.PostRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader {

    private final PersonRepository personRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public DataLoader(PersonRepository personRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.personRepository = personRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        loadDatabase();
    }

    private void loadDatabase(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<Person[]> responseEntity = restTemplate.getForEntity(url, Person[].class);
        List<Person> personList = Arrays.asList(responseEntity.getBody());
        personRepository.saveAll(personList);

        String urlPosts = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post[]> responseEntity2 = restTemplate.getForEntity(urlPosts, Post[].class);
        List<Post> posts = Arrays.asList(responseEntity2.getBody());
        postRepository.saveAll(posts);

        String urlComm = "https://jsonplaceholder.typicode.com/comments";
        ResponseEntity<Comment[]> responseEntity3 = restTemplate.getForEntity(urlComm, Comment[].class);
        List<Comment> comments = Arrays.asList(responseEntity3.getBody());
        commentRepository.saveAll(comments);

    }
}
