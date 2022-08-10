package com.onlineJobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineJobPortal.entity.Favourites;
import com.onlineJobPortal.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouritesRepo extends JpaRepository<Favourites, Long> {

    boolean existsByJobIdAndUser(String jobId, User user);

    List<Favourites> findAllByUserId(Long userId);

    Optional<Favourites> findByJobId(String id);
}
