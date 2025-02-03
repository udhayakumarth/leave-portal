package dev.udhayakumar.leave_portal.Leave;

import dev.udhayakumar.leave_portal.UserDetails.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, String> {
    List<Leave> findAllByUser(UserDetails userDetails);
}
