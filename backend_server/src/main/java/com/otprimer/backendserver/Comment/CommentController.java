package com.otprimer.backendserver.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @GetMapping
    public Iterable<Comment> findAllComments(){
        return commentRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> findCommentById(@PathVariable(value = "id") Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isPresent()) {
            return ResponseEntity.ok().body(comment.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Comment saveComment(@Validated @RequestBody Comment comment) {
        System.out.println(comment);
        return commentRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable(value = "id") Integer id) {
        commentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
