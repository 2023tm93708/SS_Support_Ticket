package wilp.bits.pilani.ss_support_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/user/{userId}")
    public List<SupportTicket> getTicketsByUserId(@PathVariable Long userId) {
        System.out.println("\n\n---\t:\t"+userId+"\n\n");
        return service.getTicketsByUserId(userId);
    }

    @PutMapping("/{ticketId}")
    public SupportTicket updateTicket(@PathVariable Long ticketId, @RequestBody SupportTicket updatedTicket) {
        return service.updateTicket(ticketId, updatedTicket);
    }
}
