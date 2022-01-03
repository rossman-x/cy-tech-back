package com.cytech.cytechback.wish;

import com.cytech.cytechback.common.SimpleAssembler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishAssembler implements SimpleAssembler<WishDTO, Wish> {
    @Override
    public WishDTO toDto(Wish w) {
        WishDTO dto = new WishDTO();
        dto.setId(w.getId());
        dto.setOption(w.getOption());
        dto.setRank(w.getRank());
        dto.setUserOfWish(w.getUserOfWish());

        return dto;
    }

    @Override
    public Wish fromDto(WishDTO dto) {
        Wish w = new Wish();
        w.setOption(dto.getOption());
        w.setRank(dto.getRank());
        w.setUserOfWish(dto.getUserOfWish());

        return w;
    }

    @Override
    public List<WishDTO> toDtoList(List<Wish> wishes) {
        if(wishes != null && !wishes.isEmpty())
            return wishes.stream().map(this::toDto).collect(Collectors.toList());
        return Collections.emptyList();
    }

    @Override
    public List<Wish> fromDtoList(List<WishDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty())
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        return Collections.emptyList();
    }
}
