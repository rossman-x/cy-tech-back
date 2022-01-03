package com.cytech.cytechback.wish;

import com.cytech.cytechback.option.Option;
import com.cytech.cytechback.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishService implements IWishService {

    @Autowired
    private WishAssembler wishAssembler;

    @Autowired
    private WishRepository wishRepository;

    @Override
    public List<WishDTO> getWishList(Long userId) {
        Collection<Wish> wishes = this.wishRepository.getAllByUserId(userId);
        List<Wish> listOfWishes = wishes.stream().collect(Collectors.toList());
        return this.wishAssembler.toDtoList(listOfWishes);
    }

    @Override
    public void createManyWishes(Long userId, Long firstWishId, Long secondWishId, Long thirdWishId, Long forthWishId) {
        Long[] wishes = {firstWishId, secondWishId, thirdWishId, forthWishId};
        for (int i = 0; i < wishes.length; i++) {
            Wish wish = new Wish();
            wish.setUserId(userId);
            Option option = new Option();
            option.setId(wishes[i]);
            wish.setOption(option);
            wish.setRank(i + 1);
            this.wishRepository.save(wish);
        }
    }
}
