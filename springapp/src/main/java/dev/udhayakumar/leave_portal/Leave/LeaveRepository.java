package dev.udhayakumar.leave_portal.Leave;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, String> {
}
