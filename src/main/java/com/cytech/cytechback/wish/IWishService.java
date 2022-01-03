package com.cytech.cytechback.wish;

import java.util.List;

public interface IWishService {

    List<WishDTO> getWishList(Long userId);

    void createManyWishes(Long userId, Long firstWishId, Long secondWishId, Long thirdWishId, Long forthWishId);
}
