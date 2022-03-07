package com.mission3.Community.repository;

import com.mission3.Community.model.Post;
import com.mission3.Community.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
