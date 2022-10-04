package com.mycode.springbootangular.repository;

import com.mycode.springbootangular.model.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubredditRepository extends JpaRepository<SubReddit, Long> {

}
