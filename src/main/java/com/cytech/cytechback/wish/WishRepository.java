package com.cytech.cytechback.wish;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public interface WishRepository extends JpaRepository<Wish, Long> {

    Collection<Wish> getAllByUserId(Long userOfWishId);

    @Transactional
    void deleteAllByUserId(Long userId);
}
