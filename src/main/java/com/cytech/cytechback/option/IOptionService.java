package com.cytech.cytechback.option;

import com.cytech.cytechback.user.UserDTO;

import java.util.List;

public interface IOptionService {

    List<OptionDTO> getOptionsBySpecialityId(Long specialityId);

    List<Long> setOrientationForOption(Long optionId);

    OptionDTO getOption(Long optionId);

    List<OptionDTO> getOptions();

}
