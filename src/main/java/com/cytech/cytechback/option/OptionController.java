package com.cytech.cytechback.option;

import com.cytech.cytechback.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController implements IOptionController {

    @Autowired
    private OptionService optionService;

    @Override
    @GetMapping(path = "list")
    public ResponseEntity<List<OptionDTO>> getOptions() {
        return ResponseEntity.ok(this.optionService.getOptions());
    }

    @Override
    @GetMapping(path = "")
    public ResponseEntity<List<OptionDTO>> getOptionsBySpecialityId(Long specialityId) {
        return ResponseEntity.ok(this.optionService.getOptionsBySpecialityId(specialityId));
    }

    @Override
    @GetMapping(path = "setOrientation")
    public ResponseEntity<List<Long>> setOrientationForOption(Long optionId) {
        List<Long> list = this.optionService.setOrientationForOption(optionId);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(path = "get")
    public ResponseEntity<OptionDTO> getOption(Long optionId) {
        return ResponseEntity.ok(this.optionService.getOption(optionId));
    }
}
