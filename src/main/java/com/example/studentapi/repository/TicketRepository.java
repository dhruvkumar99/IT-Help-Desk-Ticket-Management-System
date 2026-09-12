package com.example.studentapi.repository;

import com.example.studentapi.entity.Ticket;
import com.example.studentapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser(User user);
    List<Ticket> findByStatus(String status);
    List<Ticket> findByPriority(String priority);
}