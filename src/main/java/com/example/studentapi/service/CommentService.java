package com.example.studentapi.service;

import com.example.studentapi.entity.Comment;
import com.example.studentapi.entity.Ticket;
import com.example.studentapi.repository.CommentRepository;
import com.example.studentapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Comment addComment(Long ticketId, Comment comment) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
        comment.setTicket(ticket);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByTicketId(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
        return commentRepository.findByTicketOrderByCreatedAtAsc(ticket);
    }
}