package com.cytech.cytechback.speciality;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISpecialityController {

    @Operation(summary = "Get All Specialities")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<SpecialityDTO>> getSpecialities();
}
