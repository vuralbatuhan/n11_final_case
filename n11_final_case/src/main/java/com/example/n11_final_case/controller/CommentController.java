package com.example.n11_final_case.controller;

/*
 * @author batuhanvural
 */

import com.example.n11_final_case.dto.CommentDto;
import com.example.n11_final_case.dto.UserDto;
import com.example.n11_final_case.service.CommentService;
import com.example.n11_final_case.util.LoggerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    final private CommentService commentService;

    @GetMapping("/getAll")
    public List<CommentDto> getAllComment() {
        return commentService.getAllComment();
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment) {
        LoggerHandler.getLogger().log(Level.INFO,
                "CommentController --> createComment() --> Comment has been sent to CommentService createComment()");
        CommentDto resultComment = commentService.createComment(comment);
        return ResponseEntity.ok(resultComment);
    }
    @DeleteMapping("/delete/{id}")
    public CommentDto deleteComment(@PathVariable int id) {
        LoggerHandler.getLogger().log(Level.INFO,
                "CommentController --> deleteComment() --> Comment id has been sent to CommentService deleteComment()");
        return commentService.deleteComment(id);
    }
    @PutMapping("/update/{id}")
    public CommentDto updateComment(@PathVariable int id, @RequestBody CommentDto comment) {
        return commentService.updateComment(id, comment);
    }

}
