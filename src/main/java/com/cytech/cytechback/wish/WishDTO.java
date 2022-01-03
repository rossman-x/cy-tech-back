package com.cytech.cytechback.wish;

import com.cytech.cytechback.common.SimpleDto;
import com.cytech.cytechback.option.Option;
import com.cytech.cytechback.user.User;

public class WishDTO implements SimpleDto {

    long id;
    User userOfWish;
    Option option;
    int rank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserOfWish() {
        return userOfWish;
    }

    public void setUserOfWish(User userOfWish) {
        this.userOfWish = userOfWish;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
