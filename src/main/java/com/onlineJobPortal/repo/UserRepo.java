package com.onlineJobPortal.repo;

import com.onlineJobPortal.dto.UserDto;
import com.onlineJobPortal.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

}
