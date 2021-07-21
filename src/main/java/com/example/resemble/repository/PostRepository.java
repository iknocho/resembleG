package com.example.resemble.repository;

import com.example.resemble.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository???상속
public interface PostRepository extends JpaRepository<Post,Long> {

}
