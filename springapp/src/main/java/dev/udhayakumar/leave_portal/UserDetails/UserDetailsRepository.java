package dev.udhayakumar.leave_portal.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    Optional<UserDetails> findByUserName(String username);
}
