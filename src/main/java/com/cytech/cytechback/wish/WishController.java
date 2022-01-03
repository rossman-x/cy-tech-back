package com.cytech.cytechback.wish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wishes")
public class WishController implements IWishController {


    @Autowired
    private WishService wishService;


    @GetMapping(path = "")
    @Override
    public ResponseEntity<List<WishDTO>> getWishList(Long userId) {
        return ResponseEntity.ok(this.wishService.getWishList(userId));
    }

    @GetMapping(path = "create_many")
    @Override
    public ResponseEntity<Void> createManyWishes(Long userId, Long firstWishId, Long secondWishId, Long thirdWishId, Long forthWishId) {
        this.wishService.createManyWishes(userId, firstWishId, secondWishId, thirdWishId, forthWishId);
        return ResponseEntity.ok().build();
    }

}
