package com.otprimer.backendserver.Comment;

import com.otprimer.backendserver.Review.ReviewInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel,Integer> {
}
