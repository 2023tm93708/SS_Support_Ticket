package wilp.bits.pilani.ss_support_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wilp.bits.pilani.ss_support_ticket.entity.SupportTicket;

import java.util.List;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    List<SupportTicket> findByUserId(Long userId);
}
