package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    org.springframework.security.core.userdetails.UserDetails findByUsername();
}
