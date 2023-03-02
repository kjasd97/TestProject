package ukr.spring.test.Project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ukr.spring.test.Project.dto.PostDTO;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.repositories.PostRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PostsService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void savePosts(List<Post> posts) {
        postRepository.saveAll(posts);
    }

    public Optional<Post> getById(int id) {
        return postRepository.findById(id);
    }

    @Transactional
    public void save(Post post) {
        postRepository.save(post);
    }

    public Post convertToPost(PostDTO postDTO){
    return modelMapper.map(postDTO, Post.class);
    }

    public List <Post> convertToPosts(List <PostDTO> postDTO){
        return postDTO.stream().map(postDTO1 -> modelMapper.map(postDTO1, Post.class)).
                collect(Collectors.toList());
    }

    public Post findPostByTitle(String title){
        return postRepository.findPostByTitle(title);
    }
}
