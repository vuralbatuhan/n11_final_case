package com.example.n11_final_case.service;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dao.CommentDao;
import com.example.n11_final_case.dto.CommentDto;
import com.example.n11_final_case.entity.Comment;
import com.example.n11_final_case.exception.CommentNotFoundException;
import com.example.n11_final_case.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentDao commentDao;
    private final ModelMapper modelMapper;

    public List<CommentDto> getAllComment() {
        List<Comment> commentList = commentDao.getAllComment();
        List<CommentDto> commentDtoList = commentList.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
        return commentDtoList;
    }

    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        LoggerHandler.getLogger().log(Level.INFO,
                "CommentServiceImpl --> createComment() --> New comment has been created");
        return modelMapper.map(commentDao.save(comment), CommentDto.class);
    }

    public CommentDto deleteComment(int id) {
        Comment comment = commentDao.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no such comment. Please check comment id"));
        commentDao.delete(commentDao.getById(id));
        LoggerHandler.getLogger().log(Level.INFO,
                "CommentServiceImpl --> deleteComment() --> Comment deleted by id");
        return modelMapper.map(comment, CommentDto.class);
    }
    
    public CommentDto updateComment(int id, CommentDto comment) {
        Optional<Comment> resultComment = Optional.ofNullable(commentDao.findById(id).orElseThrow(() -> new CommentNotFoundException("There is no such comment. Check comment id")));
        if(resultComment.isPresent()) {
            resultComment.get().setId(comment.getId());
            resultComment.get().setScore(comment.getScore());
            resultComment.get().setDescription(comment.getDescription());
            LoggerHandler.getLogger().log(Level.INFO,
                    "CommentSericeImpl --> updateComment() --> Comment updated by id");
            
            return modelMapper.map(commentDao.save(resultComment.get()), CommentDto.class);
            
        }else {
            return null;
        }
    }

}
