package com.mycode.springbootangular.repository;

import com.mycode.springbootangular.model.Comment;
import com.mycode.springbootangular.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
