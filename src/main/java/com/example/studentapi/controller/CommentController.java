package com.example.studentapi.controller;

import com.example.studentapi.entity.Comment;
import com.example.studentapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{ticketId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long ticketId,
                                              @RequestBody Comment comment) {
        Comment createdComment = commentService.addComment(ticketId, comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{ticketId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByTicketId(@PathVariable Long ticketId) {
        List<Comment> comments = commentService.getCommentsByTicketId(ticketId);
        return ResponseEntity.ok(comments);
    }
}