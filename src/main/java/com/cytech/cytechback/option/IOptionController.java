package com.cytech.cytechback.option;


import com.cytech.cytechback.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IOptionController {

    @Operation(summary = "Get all options")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<OptionDTO>> getOptions();


    @Operation(summary = "Get all options by one speciality id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<OptionDTO>> getOptionsBySpecialityId(@RequestParam("speciality_id") Long specialityId);

    @Operation(summary = "Set orientation for users of an option")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<Long>> setOrientationForOption(@RequestParam("option_id") Long optionId);

    @Operation(summary = "Set option by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<OptionDTO> getOption(@RequestParam("option_id") Long optionId);

}
