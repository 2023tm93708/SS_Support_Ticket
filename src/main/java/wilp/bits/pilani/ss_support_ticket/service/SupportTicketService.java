package wilp.bits.pilani.ss_support_ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.bits.pilani.ss_support_ticket.enums.Status;
import wilp.bits.pilani.ss_support_ticket.entity.SupportTicket;
import wilp.bits.pilani.ss_support_ticket.repository.SupportTicketRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository repository;

    public SupportTicket createTicket(SupportTicket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());
        ticket.setStatus(Status.OPEN);
        return repository.save(ticket);
    }

    public List<SupportTicket> getTicketsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public SupportTicket updateTicket(Long ticketId, SupportTicket updatedTicket) {
        return repository.findById(ticketId).map(ticket -> {
            ticket.setSubject(updatedTicket.getSubject());
            ticket.setDescription(updatedTicket.getDescription());
            ticket.setPriority(updatedTicket.getPriority());
            ticket.setStatus(updatedTicket.getStatus());
            ticket.setUpdatedAt(LocalDateTime.now());
            return repository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
