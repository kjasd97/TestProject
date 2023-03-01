package ukr.spring.test.Project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ukr.spring.test.Project.dto.CommentDTO;
import ukr.spring.test.Project.dto.PostDTO;
import ukr.spring.test.Project.models.Comment;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class CommentsService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentsService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    @Transactional
    public void saveComments(List<Comment> comments){
        commentRepository.saveAll(comments);
    }



    public Comment convertToComment(CommentDTO commentDTO){
        return modelMapper.map(commentDTO, Comment.class);
    }

    public List <Comment> convertToComments(List <CommentDTO> commentDTOS){
        return commentDTOS.stream().map(commentDTO -> modelMapper.map(commentDTO, Comment.class)).
                collect(Collectors.toList());
    }
}

