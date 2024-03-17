package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dto.CommentDto;
import com.example.n11_final_case.entity.Comment;

import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);
    List<CommentDto> getAllComment();
    CommentDto updateComment(int id, CommentDto comment);
    CommentDto deleteComment(int id);

}
