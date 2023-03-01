package ukr.spring.test.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukr.spring.test.Project.dto.PostDTO;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.service.PostsService;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostsService postsService;

    @Autowired
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PutMapping
    public ResponseEntity<Void> createPosts(@RequestBody List<PostDTO> postsDTO){
        List<Post> posts = postsService.convertToPosts(postsDTO);
        postsService.savePosts(posts);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostDTO postDTO){
        Post post = postsService.convertToPost(postDTO);
        postsService.save(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id){
      return ResponseEntity.of(postsService.getById(id));
    }

}
