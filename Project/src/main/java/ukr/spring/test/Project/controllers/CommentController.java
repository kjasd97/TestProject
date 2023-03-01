package ukr.spring.test.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukr.spring.test.Project.dto.CommentDTO;
import ukr.spring.test.Project.models.Comment;
import ukr.spring.test.Project.models.Post;
import ukr.spring.test.Project.service.CommentsService;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentsService commentsService;

    @Autowired
    public CommentController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createComment (@RequestBody CommentDTO commentDTO){
        Comment comment = commentsService.convertToComment(commentDTO);
        commentsService.saveComment(comment);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> createComments(@RequestBody List<CommentDTO> commentsDTO){
        List<Comment> comments = commentsService.convertToComments(commentsDTO);
        commentsService.saveComments(comments);
        return ResponseEntity.ok().build();
    }

//    @PostMapping
//    public ResponseEntity<HttpStatus> createComment (@RequestBody Comment comment){
//        commentsService.saveComment(comment);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<HttpStatus> createComments(@RequestBody List<Comment> comments){
//
//        commentsService.saveComments(comments);
//        return ResponseEntity.ok().build();
//    }
}
