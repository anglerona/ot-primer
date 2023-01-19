package com.otprimer.backendserver.Vote;

import com.otprimer.backendserver.Review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // This allows for automatic response body
@RequestMapping(path="/vote")
public class VoteController {
    @Autowired

    private VoteRepository voteRepository;

    @GetMapping()
    public Iterable<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @PostMapping()
    public Vote saveVote(@Validated @RequestBody Vote vote) {
        System.out.println(vote);
        return voteRepository.save(vote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vote> deleteVoteById(@PathVariable(value = "id") Integer id) {
        voteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
