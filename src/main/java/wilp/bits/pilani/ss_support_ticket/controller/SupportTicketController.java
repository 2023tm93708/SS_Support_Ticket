package wilp.bits.pilani.ss_support_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wilp.bits.pilani.ss_support_ticket.entity.SupportTicket;
import wilp.bits.pilani.ss_support_ticket.service.SupportTicketService;

import java.util.List;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService service;

    @PostMapping
    public SupportTicket createTicket(@RequestBody SupportTicket ticket) {
        return service.createTicket(ticket);
    }

    @GetMapping
    public List<SupportTicket> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/user/{userId}")
    public List<SupportTicket> getTicketsByUserId(@PathVariable Long userId) {
        System.out.println("\n\n---\t:\t"+userId+"\n\n");
        return service.getTicketsByUserId(userId);
    }

    @PutMapping("/{ticketId}")
    public SupportTicket updateTicket(@PathVariable Long ticketId, @RequestBody SupportTicket updatedTicket) {
        return service.updateTicket(ticketId, updatedTicket);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long ticketId) {
        try {
            service.deleteTicket(ticketId);
            return ResponseEntity.ok("Ticket with ID " + ticketId + " has been successfully deleted.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Failed to delete ticket: " + ex.getMessage());
        }
    }
}
