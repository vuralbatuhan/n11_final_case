package com.example.n11_final_case.dao;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    @Query("from Comment ")
    List<Comment> getAllComment();

}
